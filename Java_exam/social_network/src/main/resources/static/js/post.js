document.addEventListener("DOMContentLoaded", loadFeed);

async function loadFeed() {
    const token = localStorage.getItem("token");
    if (!token) {
        // не авторизован — редирект
        window.location.href = "/login";
        return;
    }

    try {
        const res = await fetch("/api/posts", {
            headers: { "Authorization": "Bearer " + token }
        });

        if (res.status === 403) {
            localStorage.removeItem("token");
            window.location.href = "/login";
            return;
        }

        const posts = await res.json();
        renderPosts(posts);
    } catch (e) {
        console.error(e);
        alert("Ошибка загрузки ленты.");
    }
}

function renderPosts(posts) {
    const container = document.getElementById("posts-container");
    container.innerHTML = "";

    if (!Array.isArray(posts) || posts.length === 0) {
        container.innerHTML = "<p>Пока что нет постов.</p>";
        return;
    }

    posts.forEach(post => {
        const imgHtml = post.imageUrl ? `<img class="post-image" src="${post.imageUrl}" alt="">` : "";
        const username = post.user?.username || "Неизвестный";
        const avatar = post.user?.imageUrl || "/images/default-avatar.png";

        const card = document.createElement("div");
        card.className = "post";
        card.innerHTML = `
            <div class="post-header">
                <img class="post-avatar" src="${avatar}" alt="avatar">
                <span class="post-username">${escapeHtml(username)}</span>
            </div>
            <div class="post-content">${escapeHtml(post.content)}</div>
            ${imgHtml}
            <div class="post-actions">
                <span class="like-btn" data-post="${post.id}">❤ <span class="likes-count">${post.likesCount || 0}</span></span>
                <span class="comment-btn" data-post="${post.id}">💬 Комментарии</span>
            </div>
        `;

        container.appendChild(card);
    });

    // навесим обработчики
    document.querySelectorAll(".like-btn").forEach(el => {
        el.addEventListener("click", () => likePost(el.dataset.post, el));
    });
    document.querySelectorAll(".comment-btn").forEach(el => {
        el.addEventListener("click", () => openComments(el.dataset.post));
    });
}

async function likePost(postId, el) {
    const token = localStorage.getItem("token");
    if (!token) {
        window.location.href = "/login";
        return;
    }

    try {
        const res = await fetch(`/api/posts/${postId}/like`, {
            method: "POST",
            headers: { "Authorization": "Bearer " + token }
        });

        if (res.status === 403) {
            localStorage.removeItem("token");
            window.location.href = "/login";
            return;
        }

        // можно обновить счётчик локально, но проще перезагрузить ленту:
        await loadFeed();
    } catch (e) {
        console.error(e);
    }
}

function openComments(postId) {
    window.location.href = `/comments?post=${postId}`;
}

function escapeHtml(unsafe) {
    if (!unsafe && unsafe !== 0) return "";
    return String(unsafe)
        .replaceAll("&", "&amp;")
        .replaceAll("<", "&lt;")
        .replaceAll(">", "&gt;")
        .replaceAll('"', "&quot;")
        .replaceAll("'", "&#039;");
}