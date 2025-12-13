function q(id) { return document.getElementById(id); }

let token = null;
let currentUserId = null;
let currentReceiverId = null;
let refreshTimer = null;

document.addEventListener('DOMContentLoaded', initMessages);

async function initMessages() {
    token = localStorage.getItem("token");
    currentUserId = localStorage.getItem("userId");

    const sendButton = q('sendButton');
    const messageInput = q('messageInput');

    if (!token || !currentUserId) {
        window.location.href = "/login";
        return;
    }

    await loadDialogsList();

    if (sendButton) sendButton.addEventListener('click', sendMessage);
    if (messageInput) messageInput.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') sendMessage();
    });

    const params = new URLSearchParams(window.location.search);
    const initialReceiverId = params.get('receiverId');

    if (initialReceiverId && !isNaN(initialReceiverId)) {
        await autoOpenDialog(initialReceiverId);
        history.replaceState(null, '', '/messages');
    }
}

async function loadDialogsList() {
    const dialogsList = q('dialogsList');
    if (!dialogsList) return;

    dialogsList.innerHTML = `
        <h3>Диалоги</h3>
        <p style="font-size:0.85em;color:#777;padding:0 10px;">
            (Пользователи, на которых вы подписаны)
        </p>
    `;

    try {
        const res = await fetch(`/api/users/${currentUserId}/following`, {
            headers: { "Authorization": "Bearer " + token }
        });

        if (!res.ok) {
            dialogsList.innerHTML += `<p style="color:#777;padding:10px;">Ошибка загрузки</p>`;
            return;
        }

        const following = await res.json();

        if (!following.length) {
            dialogsList.innerHTML += `<p style="color:#777;padding:10px;">Вы ни на кого не подписаны</p>`;
            return;
        }

        following.forEach(item => {
            if (!item.followingId) return;

            const div = document.createElement('div');
            div.className = 'dialog-item';
            div.dataset.userId = item.followingId;

            div.innerHTML = `
                <div style="display:flex;align-items:center;gap:10px;">
                    <img
                        src="${item.imageUrl || '/images/default-avatar.png'}"
                        style="width:36px;height:36px;border-radius:50%;object-fit:cover;"
                    />
                    <strong>${escapeHtml(item.username)}</strong>
                </div>
            `;

            div.onclick = () => {
                selectDialog(
                    String(item.followingId),
                    item.username
                );
            };

            dialogsList.appendChild(div);
        });

    } catch (e) {
        console.error(e);
        dialogsList.innerHTML += `<p style="color:#777;padding:10px;">Ошибка</p>`;
    }
}

function selectDialog(userId, username) {
    if (!userId || userId === "null") return;
    if (currentReceiverId === userId) return;

    if (refreshTimer) {
        clearInterval(refreshTimer);
        refreshTimer = null;
    }

    currentReceiverId = userId;

    document.querySelectorAll('.dialog-item').forEach(el => el.classList.remove('active'));
    const selectedDialog = document.querySelector(`.dialog-item[data-user-id='${userId}']`);
    if (selectedDialog) selectedDialog.classList.add('active');

    const chatTitle = q('chatWindowTitle');
    if (chatTitle) chatTitle.textContent = `Чат с ${username}`;

    loadMessages(currentUserId, currentReceiverId, true);

    refreshTimer = setInterval(async () => {
        if (!currentReceiverId) {
            clearInterval(refreshTimer);
            return;
        }

        await loadMessages(currentUserId, currentReceiverId, false);

    }, 3000);
}

async function autoOpenDialog(receiverId) {
    try {
        const userRes = await fetch(`/api/users/${receiverId}`, {headers: {"Authorization": "Bearer " + token}});
        if (userRes.ok) {
            const user = await userRes.json();
            selectDialog(String(receiverId), user.username || 'Пользователь');
        }
    } catch (e) {
        console.error(e);
    }
}

async function loadMessages(user1Id, user2Id, shouldScroll) {
    const messagesContainer = q('messagesContainer');
    if (!messagesContainer) return;

    if (shouldScroll) {
        messagesContainer.innerHTML = '<p style="text-align:center; color:#777;">Загрузка сообщений...</p>';
    }

    if (!user2Id) {
        messagesContainer.innerHTML = '<p style="text-align:center; color:#777;">Выберите диалог.</p>';
        return;
    }

    try {
        const res = await fetch(`/api/messages/dialog?user1=${encodeURIComponent(user1Id)}&user2=${encodeURIComponent(user2Id)}`, {
            headers: {"Authorization": "Bearer " + token}
        });

        if (!res.ok) {
            console.error("Server returned error:", res.status);
            messagesContainer.innerHTML = '<p style="text-align:center; color:#777;">Ошибка загрузки сообщений.</p>';
            return;
        }

        const messages = await res.json();
        renderMessages(messages, shouldScroll);

    } catch (e) {console.error("Ошибка сети при загрузке диалога:", e);
        messagesContainer.innerHTML = '<p style="text-align:center; color:#777;">Ошибка загрузки сообщений.</p>';
    }
}

function renderMessages(messages, shouldScroll) {
    const messagesContainer = q('messagesContainer');
    if (!messagesContainer) return;

    const wasAtBottom = messagesContainer.scrollHeight - messagesContainer.clientHeight <= messagesContainer.scrollTop + 50;

    messagesContainer.innerHTML = '<div class="message-list"></div>';
    const list = messagesContainer.querySelector('.message-list');

    if (!Array.isArray(messages) || messages.length === 0) {
        list.innerHTML = '<p style="text-align:center; color:#777;">Нет сообщений в этом диалоге.</p>';
        return;
    }

    messages.forEach(msg => {
        const div = document.createElement('div');

        const isSender = Number(msg.senderId) === Number(currentUserId);

        div.className = `message ${isSender ? 'sent' : 'received'}`;
        const who = isSender ? 'Вы' : msg.senderUsername || '';

        div.innerHTML = `
            <div class="msg-meta"><small>${escapeHtml(who)}</small></div>
            <div class="msg-body">${escapeHtml(msg.content)}</div>
        `;
        list.appendChild(div);
    });

    if (shouldScroll || wasAtBottom) {
        messagesContainer.scrollTop = messagesContainer.scrollHeight;
    }
}

async function sendMessage() {
    const messageInput = q('messageInput');
    if (!messageInput) return;

    const content = messageInput.value.trim();
    if (!content || !currentReceiverId) return;

    const dto = {
        senderId: Number(currentUserId),
        receiverId: Number(currentReceiverId),
        content: content
    };

    try {
        const res = await fetch(`/api/messages`, {
            method: 'POST',
            headers: {
                "Authorization": "Bearer " + token,
                "Content-Type": "application/json"
            },
            body: JSON.stringify(dto)
        });

        if (res.ok) {
            messageInput.value = '';
            await loadMessages(currentUserId, currentReceiverId, true);
        } else {
            const err = await res.text();
            alert('Ошибка отправки сообщения: ' + err);
        }
    } catch (e) {
        console.error("Ошибка отправки:", e);
        alert('Ошибка сети при отправке сообщения.');
    }
}

function escapeHtml(text) {
    if (text === null || text === undefined) return '';
    return String(text)
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/"/g, "&quot;")
        .replace(/'/g, "&#039;");
}

window.addEventListener('beforeunload', () => {
    if (refreshTimer) clearInterval(refreshTimer);
});