document.addEventListener("DOMContentLoaded", loadAllPosts);

async function loadAllPosts() {
    const token = localStorage.getItem("token");
    const container = document.getElementById("posts-container");

    if (!token) {
        window.location.href = "/login";
        return;
    }

    try {
        const res = await fetch("/api/posts", {
            method: "GET",
            headers: {
                "Authorization": "Bearer " + token
            }
        });

        if (res.status === 401 || res.status === 403) {
            localStorage.removeItem("token");
            window.location.href = "/login";
            return;
        }

        if (!res.ok) {
            throw new Error("Ошибка загрузки данных");
        }

        const posts = await res.json();
        renderFeed(posts, container);

    } catch (e) {
        console.error(e);
        container.innerHTML = "<p style='text-align:center;'>Не удалось загрузить ленту.</p>";
    }
}

function renderFeed(posts, container) {
    container.innerHTML = "";

    if (!posts || posts.length === 0) {
        container.innerHTML = "<p style='text-align:center;'>Постов пока нет.</p>";
        return;
    }

    posts.forEach(post => {
        const date = new Date(post.createdAt).toLocaleDateString() +
            " " + new Date(post.createdAt).toLocaleTimeString().slice(0, 5);

        const username = post.user ? post.user.username : "Неизвестный";
        const userAvatar = post.user?.imageUrl || "/images/default-avatar.png";

        // ✔ Исправлено: шаблонная строка сделана правильной
        const postImageHtml = post.imageUrl
            ? `<img src="${post.imageUrl}" class="post-image" alt="Фото поста">`
            : "";

        const card = document.createElement("div");
        card.className = "post-card";

        card.innerHTML = `
            <div class="post-header">
                <img src="${userAvatar}" class="post-avatar" alt="Ava">
                <span class="post-username">${escapeHtml(username)}</span>
            </div>

            <div class="post-content">
                ${escapeHtml(post.content)}
            </div>

            ${postImageHtml}

            <div class="post-footer">
                <div class="post-actions">
                    <button class="like-btn" onclick="toggleLike(${post.id})">
                        ❤️ <span id="likes-count-${post.id}">${post.likesCount || 0}</span>
                    </button>
                </div>
                <div class="post-date">${date}</div>
            </div>
        `;

        card.innerHTML += `
    <div class="comments-toggle" onclick="toggleComments(${post.id})">
        💬 Комментарии
    </div>

    <div class="comments-section" id="comments-${post.id}" style="display: none;">
        <div class="comments-list" id="comments-list-${post.id}">
            Загрузка комментариев...
        </div>

        <div class="add-comment">
            <input type="text" id="comment-input-${post.id}" placeholder="Написать комментарий...">
            <button onclick="addComment(${post.id})">Отправить</button>
        </div>
    </div>
`;

        container.appendChild(card);
        loadComments(post.id);
    });
}

async function toggleLike(postId) {
    const token = localStorage.getItem("token");
    const userId = localStorage.getItem("userId");

    if (!userId) {
        console.error("User ID не найден, попробуйте войти снова");
        return;
    }

    try {
        const res = await fetch(`/api/posts/${postId}/like?userId=${userId}`, {
            method: "POST",
            headers: {
                "Authorization": "Bearer " + token
            }
        });

        if (res.ok) {
            loadAllPosts();
        } else {
            console.error("Ошибка лайка:", res.status);
        }

    } catch (e) {
        console.error("Ошибка сети при лайке:", e);
    }
}

function escapeHtml(text) {
    if (!text) return "";
    return text
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/"/g, "&quot;")
        .replace(/'/g, "&#039;");
}

function toggleComments(postId) {
    const block = document.getElementById(`comments-${postId}`);

    if (!block) return;

    if (block.style.display === "none") {
        block.style.display = "block";
        loadComments(postId);
    } else {
        block.style.display = "none";
    }
}

async function loadComments(postId) {
    const token = localStorage.getItem("token");
    const list = document.getElementById(`comments-list-${postId}`);

    try {
        const res = await fetch(`/api/comments/post/${postId}`, {
            method: "GET",
            headers: {
                "Authorization": "Bearer " + token
            }
        });

        if (!res.ok) {
            list.innerHTML = "<p>Не удалось загрузить комментарии.</p>";
            return;
        }

        const comments = await res.json();

        if (comments.length === 0) {
            list.innerHTML = "<p>Комментариев пока нет.</p>";
            return;
        }

        list.innerHTML = comments.map(c => `
            <div class="comment">
                <strong>Пользователь ${c.username}</strong>
                <p>${escapeHtml(c.content)}</p>
            </div>
        `).join("");

    } catch (e) {
        console.error(e);
        list.innerHTML = "<p>Ошибка загрузки комментариев.</p>";
    }
}


async function addComment(postId) {
    const token = localStorage.getItem("token");
    const userId = localStorage.getItem("userId");
    const input = document.getElementById(`comment-input-${postId}`);
    const text = input.value.trim();

    if (text.length === 0) return;

    const body = {
        userId: Number(userId),
        postId: Number(postId),
        content: text
    };

    try {
        const res = await fetch(`/api/comments`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer " + token
            },
            body: JSON.stringify(body)
        });

        if (res.ok) {
            input.value = "";
            loadComments(postId);
        } else {
            console.error("Ошибка при отправке комментария:", res.status);
        }

    } catch (e) {
        console.error("Ошибка сети при отправке комментария:", e);
    }
}