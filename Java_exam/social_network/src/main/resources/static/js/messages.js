// document.addEventListener('DOMContentLoaded', initMessages);
//
// const token = localStorage.getItem("token");
// const currentUserId = localStorage.getItem("userId");
// let currentReceiverId = null;
// let refreshTimer = null;
//
// const messagesContainer = document.getElementById('messagesContainer');
// const dialogsList = document.getElementById('dialogsList');
// const messageInput = document.getElementById('messageInput');
// const sendButton = document.getElementById('sendButton');
// const chatWindowTitle = document.getElementById('chatWindowTitle'); // Нужно добавить в HTML
//
// async function initMessages() {
//     if (!currentUserId || !token) {
//         window.location.href = "/login";
//         return;
//     }
//
//     await loadDialogsList();
//
//     const params = new URLSearchParams(window.location.search);
//     const initialReceiverId = params.get('receiverId');
//
//     if (initialReceiverId && initialReceiverId !== null) {
//         try {
//             const userRes = await fetch(`/api/users/${initialReceiverId}`, { headers: { "Authorization": "Bearer " + token } });
//             const user = await userRes.json();
//
//             selectDialog(initialReceiverId, user.username);
//
//             await autoOpenDialog(initialReceiverId);
//
//             history.pushState(null, '', '/messages');
//         } catch (e) {
//             console.error("Ошибка автооткрытия диалога:", e);
//         }
//     }
//
//     sendButton.addEventListener('click', sendMessage);
//     messageInput.addEventListener('keypress', (e) => {
//         if (e.key === 'Enter') {
//             sendMessage();
//         }
//     });
// }
//
// async function autoOpenDialog(receiverId) {
//     try {
//         const userRes = await fetch(`/api/users/${receiverId}`, {
//             headers: { "Authorization": "Bearer " + token }
//         });
//
//         if (!userRes.ok) return;
//
//         const user = await userRes.json();
//
//         selectDialog(receiverId, user.username);
//
//         history.pushState(null, '', '/messages');
//
//     } catch (e) {
//         console.error("Ошибка автооткрытия диалога:", e);
//     }
// }
//
// async function loadDialogsList() {
//     dialogsList.innerHTML = '<h3>Диалоги</h3>';
//
//     try {
//         const res = await fetch(`/api/users/${currentUserId}/following`, {
//             headers: { "Authorization": "Bearer " + token }
//         });
//         const followingData = await res.json();
//
//         if (followingData.length === 0) {
//             dialogsList.innerHTML += '<p style="color:#777;">Нет подписок для диалогов.</p>';
//             return;
//         }
//
//         for (const item of followingData) {
//             const receiverId = item.followingId;
//
//             const userRes = await fetch(`/api/users/${receiverId}`, { headers: { "Authorization": "Bearer " + token } });
//             const user = await userRes.json();
//
//             const dialogRes = await fetch(`/api/messages/dialog?user1=${currentUserId}&user2=${receiverId}`, {
//                 headers: { "Authorization": "Bearer " + token }
//             });
//             const messages = await dialogRes.json();
//             const lastMessage = messages.length > 0 ? messages[messages.length - 1].content : "Начните диалог...";
//
//             const dialogDiv = document.createElement('div');
//             dialogDiv.className = 'dialog-item';
//             dialogDiv.dataset.userId = receiverId;
//             dialogDiv.innerHTML = `
//                 <strong>${user.username}</strong>
//                 <p style="font-size:0.8em; color:#bbb; margin:0; overflow:hidden; white-space:nowrap; text-overflow:ellipsis;">${lastMessage}</p>
//             `;
//             dialogDiv.onclick = () => selectDialog(receiverId, user.username);
//             dialogsList.appendChild(dialogDiv);
//         }
//
//     } catch (e) {
//         console.error("Ошибка загрузки диалогов:", e);
//         dialogsList.innerHTML += '<p style="color:#777;">Ошибка загрузки.</p>';
//     }
// }
//
// function selectDialog(userId, username) {
//
//     if (!userId || userId === "null") return;
//
//     if (currentReceiverId === userId) return;
//
//     if (refreshTimer) clearInterval(refreshTimer);
//
//     currentReceiverId = userId;
//
//     document.querySelectorAll('.dialog-item').forEach(el => el.classList.remove('active'));
//
//     const selectedDialog = document.querySelector(`.dialog-item[data-user-id='${userId}']`);
//     if (selectedDialog) selectedDialog.classList.add('active');
//
//     loadMessages(currentUserId, currentReceiverId, true);
//
//     refreshTimer = setInterval(() => {
//         loadMessages(currentUserId, currentReceiverId, false);
//         loadDialogsList();
//     }, 3000);
// }
//
//
// }
//
// async function loadMessages(user1Id, user2Id, shouldScroll) {
//     if (shouldScroll) {
//         messagesContainer.innerHTML = '<p style="text-align:center; color:#777;">Загрузка сообщений...</p>';
//     }
//
//     try {
//         const res = await fetch(`/api/messages/dialog?user1=${user1Id}&user2=${user2Id}`, {
//             headers: { "Authorization": "Bearer " + token }
//         });
//
//         if (!res.ok) {
//             messagesContainer.innerHTML = '<p style="text-align:center; color:#777;">Ошибка загрузки сообщений.</p>';
//             if (refreshTimer) clearInterval(refreshTimer);
//             return;
//         }
//
//         const messages = await res.json();
//         renderMessages(messages, shouldScroll);
//
//     } catch (e) {
//         console.error("Ошибка загрузки диалога:", e);
//     }
// }
//
// function renderMessages(messages, shouldScroll) {
//     const wasAtBottom = messagesContainer.scrollHeight - messagesContainer.clientHeight <= messagesContainer.scrollTop + 1;
//
//     messagesContainer.innerHTML = '<div class="message-list"></div>';
//     const list = messagesContainer.querySelector('.message-list');
//
//     if (messages.length === 0) {
//         list.innerHTML = '<p style="text-align:center; color:#777;">Нет сообщений в этом диалоге.</p>';
//         return;
//     }
//
//     messages.forEach(msg => {
//         const div = document.createElement('div');
//         div.className = `message ${msg.senderId == currentUserId ? 'sent' : 'received'}`;
//         div.textContent = msg.content;
//         list.appendChild(div);
//     });
//
//     if (shouldScroll || wasAtBottom) {
//         messagesContainer.scrollTop = messagesContainer.scrollHeight;
//     }
// }
//
// async function sendMessage() {
//     const content = messageInput.value.trim();
//     if (!content || !currentReceiverId) return;
//
//     const dto = {
//         senderId: currentUserId,
//         receiverId: currentReceiverId,
//         content: content
//     };
//
//     try {
//         const res = await fetch(`/api/messages`, {
//             method: 'POST',
//             headers: {
//                 "Authorization": "Bearer " + token,
//                 "Content-Type": "application/json"
//             },
//             body: JSON.stringify(dto)
//         });
//
//         if (res.ok) {
//             messageInput.value = '';
//             loadMessages(currentUserId, currentReceiverId, true);
//             loadDialogsList();
//         } else {
//             const errorText = await res.text();
//             alert('Ошибка отправки сообщения: ' + errorText);
//         }
//
//     } catch (e) {
//         console.error("Ошибка отправки:", e);
//         alert('Ошибка сети при отправке сообщения.');
//     }
// }
//
// window.addEventListener('beforeunload', () => {
//     if (refreshTimer) {
//         clearInterval(refreshTimer);
//     }
// });

// messages.js — замените полностью этим кодом

document.addEventListener('DOMContentLoaded', initMessages);

let token = null;
let currentUserId = null;
let currentReceiverId = null;
let refreshTimer = null;

function q(id) { return document.getElementById(id); }

async function initMessages() {
    token = localStorage.getItem("token");
    currentUserId = localStorage.getItem("userId");

    const messagesContainer = q('messagesContainer');
    const dialogsList = q('dialogsList');
    const messageInput = q('messageInput');
    const sendButton = q('sendButton');

    if (!token || !currentUserId) {
        window.location.href = "/login";
        return;
    }

    if (sendButton) sendButton.addEventListener('click', sendMessage);
    if (messageInput) messageInput.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') sendMessage();
    });

    await loadDialogsList();

    const params = new URLSearchParams(window.location.search);
    const initialReceiverId = params.get('receiverId');
    if (initialReceiverId) {

        if (!isNaN(initialReceiverId)) {
            await autoOpenDialog(initialReceiverId);
            history.replaceState(null, '', '/messages');
        }
    }
}

async function loadDialogsList() {
    const dialogsList = q('dialogsList');
    dialogsList.innerHTML = '<h3>Диалоги</h3>';

    try {
        const res = await fetch(`/api/users/${encodeURIComponent(currentUserId)}/following`, {
            headers: { "Authorization": "Bearer " + token }
        });

        if (!res.ok) {
            dialogsList.innerHTML += '<p style="color:#777;">Не удалось загрузить подписки.</p>';
            return;
        }

        const followingData = await res.json();
        if (!Array.isArray(followingData) || followingData.length === 0) {
            dialogsList.innerHTML += '<p style="color:#777;">Нет подписок для диалогов.</p>';
            return;
        }

        for (const item of followingData) {
            const receiverId = item.followingId;
            if (!receiverId) continue;

            const userRes = await fetch(`/api/users/${receiverId}`, { headers: { "Authorization": "Bearer " + token }});
            if (!userRes.ok) continue;
            const user = await userRes.json();

            let lastMessage = "Начните диалог...";
            try {
                const dialogRes = await fetch(`/api/messages/dialog?user1=${currentUserId}&user2=${receiverId}`, {
                    headers: { "Authorization": "Bearer " + token }
                });
                if (dialogRes.ok) {
                    const messages = await dialogRes.json();
                    if (Array.isArray(messages) && messages.length > 0) {
                        lastMessage = messages[messages.length - 1].content || lastMessage;
                    }
                }
            } catch (e) {

            }

            const dialogDiv = document.createElement('div');
            dialogDiv.className = 'dialog-item';
            dialogDiv.dataset.userId = receiverId;
            dialogDiv.innerHTML = `
                <strong>${escapeHtml(user.username || 'Пользователь')}</strong>
                <p style="font-size:0.8em; color:#bbb; margin:0; overflow:hidden; white-space:nowrap; text-overflow:ellipsis;">${escapeHtml(lastMessage)}</p>
            `;
            dialogDiv.addEventListener('click', () => selectDialog(String(receiverId), user.username || ''));
            dialogsList.appendChild(dialogDiv);
        }

    } catch (e) {
        console.error("Ошибка загрузки диалогов:", e);
        dialogsList.innerHTML += '<p style="color:#777;">Ошибка загрузки.</p>';
    }
}

    // async function initMessages() {
    //     if (!currentUserId || !token) {
    //         window.location.href = "/login";
    //         return;
    //     }
    //
    //     await loadDialogsList();
    //
    //     const params = new URLSearchParams(window.location.search);
    //     const initialReceiverId = params.get('receiverId');
    //
    //     let targetElement = null;
    //
    //     if (initialReceiverId) {
    //         targetElement = dialogsList.querySelector(`.dialog-item[data-user-id='${initialReceiverId}']`);
    //         history.pushState(null, '', '/messages');
    //     }
    //
    //     if (!targetElement) {
    //         targetElement = dialogsList.querySelector('.dialog-item');
    //     }
    //
    //
    //     if (targetElement) {
    //         const userId = targetElement.dataset.userId;
    //
    //         targetElement.click();
    //
    //     } else {
    //         if (q('chatWindowTitle')) q('chatWindowTitle').textContent = 'Нет активных диалогов';
    //     }
    //
    //     sendButton.addEventListener('click', sendMessage);
    //     messageInput.addEventListener('keypress', (e) => {
    //         if (e.key === 'Enter') {
    //             sendMessage();
    //         }
    //     });
    // }

    async function autoOpenDialog(receiverId) {
        if (!receiverId || isNaN(receiverId)) return;

        try {
            const userRes = await fetch(`/api/users/${receiverId}`, {headers: {"Authorization": "Bearer " + token}});
            if (!userRes.ok) return;
            const user = await userRes.json();

            selectDialog(String(receiverId), user.username || '');
        } catch (e) {
            console.error("Ошибка автооткрытия диалога:", e);
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

        loadMessages(currentUserId, currentReceiverId, true);

        refreshTimer = setInterval(async () => {
            // безопасно: если receiver вдруг null — остановим
            if (!currentReceiverId) {
                clearInterval(refreshTimer);
                refreshTimer = null;
                return;
            }
            await loadMessages(currentUserId, currentReceiverId, false);
            await loadDialogsList();
        }, 3000);
    }

    async function loadMessages(user1Id, user2Id, shouldScroll) {
        const messagesContainer = q('messagesContainer');
        if (!messagesContainer) return;

        if (shouldScroll) {
            messagesContainer.innerHTML = '<p style="text-align:center; color:#777;">Загрузка сообщений...</p>';
        }

        // защита: если user2Id отсутствует — ничего не запрашиваем
        if (!user2Id) {
            messagesContainer.innerHTML = '<p style="text-align:center; color:#777;">Выберите диалог.</p>';
            return;
        }

        try {
            const res = await fetch(`/api/messages/dialog?user1=${encodeURIComponent(user1Id)}&user2=${encodeURIComponent(user2Id)}`, {
                headers: {"Authorization": "Bearer " + token}
            });

            if (!res.ok) {
                messagesContainer.innerHTML = '<p style="text-align:center; color:#777;">Ошибка загрузки сообщений.</p>';
                return;
            }

            const messages = await res.json();
            renderMessages(messages, shouldScroll);
        } catch (e) {
            console.error("Ошибка загрузки диалога:", e);
            messagesContainer.innerHTML = '<p style="text-align:center; color:#777;">Ошибка загрузки сообщений.</p>';
        }
    }

    function renderMessages(messages, shouldScroll) {
        const messagesContainer = q('messagesContainer');
        if (!messagesContainer) return;

        const wasAtBottom = messagesContainer.scrollHeight - messagesContainer.clientHeight <= messagesContainer.scrollTop + 1;
        messagesContainer.innerHTML = '<div class="message-list"></div>';
        const list = messagesContainer.querySelector('.message-list');

        if (!Array.isArray(messages) || messages.length === 0) {
            list.innerHTML = '<p style="text-align:center; color:#777;">Нет сообщений в этом диалоге.</p>';
            return;
        }

        messages.forEach(msg => {
            const div = document.createElement('div');
            div.className = `message ${msg.senderId == currentUserId ? 'sent' : 'received'}`;
            const who = msg.senderId == currentUserId ? 'Вы' : msg.senderUsername || '';
            div.innerHTML = `<div class="msg-meta"><small>${escapeHtml(who)}</small></div><div class="msg-body">${escapeHtml(msg.content)}</div>`;
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
                await loadDialogsList();
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
        if (refreshTimer) {
            clearInterval(refreshTimer);
        }
    });