document.addEventListener("DOMContentLoaded", loadUserProfile);

async function loadUserProfile() {
    const token = localStorage.getItem("token");
    const params = new URLSearchParams(window.location.search);
    const userId = params.get("id");

    if (!userId || !token) {
        window.location.href = "/login";
        return;
    }

    try {
        const res = await fetch(`/api/users/${userId}`, {
            headers: { "Authorization": "Bearer " + token }
        });

        if (!res.ok) {
            alert("Не удалось загрузить профиль");
            return;
        }

        const user = await res.json();

        document.getElementById("username").textContent = user.username;
        document.getElementById("email").textContent = user.email;
        document.getElementById("bio").textContent = user.bio || "";

        if (user.imageUrl) {
            document.getElementById("profileAvatar").src = user.imageUrl;
        }

        document.getElementById("followersCount").textContent = user.followersCount;
        document.getElementById("followingCount").textContent = user.followingCount;

        setupFollowButton(userId);

        setupMessageButton(userId, user.username);

        loadUserPosts(userId);

    } catch (e) {
        console.error("Ошибка загрузки профиля:", e);
    }
}

async function setupFollowButton(targetId) {
    const token = localStorage.getItem("token");
    const myId = localStorage.getItem("userId");
    const btn = document.getElementById("followBtn");

    const res = await fetch(`/api/users/${targetId}/followers`, {
        headers: { "Authorization": "Bearer " + token }
    });

    const followers = await res.json();

    const isFollowing = followers.some(f => f.followerId == myId);

    if (isFollowing) {
        btn.textContent = "Отписаться";
        btn.onclick = () => followAction(targetId, false);
    } else {
        btn.textContent = "Подписаться";
        btn.onclick = () => followAction(targetId, true);
    }
}

async function followAction(targetId, follow) {
    const token = localStorage.getItem("token");
    const followerId = localStorage.getItem("userId");

    const url = `/api/users/${targetId}/follow?followerId=${followerId}`;
    const method = follow ? "POST" : "DELETE";

    const res = await fetch(url, {
        method: method,
        headers: {
            "Authorization": "Bearer " + token
        }
    });

    if (res.ok) {
        loadUserProfile();
    } else {
        alert("Ошибка подписки");
    }
}

async function loadUserPosts(userId) {
    const token = localStorage.getItem("token");
    const container = document.getElementById("posts-container");

    const res = await fetch(`/api/posts/user/${userId}`, {
        headers: { "Authorization": "Bearer " + token }
    });

    if (!res.ok) {
        container.innerHTML = "<p style='color:#777;'>Не удалось загрузить посты</p>";
        return;
    }

    const posts = await res.json();
    renderUserPosts(posts, container);
}

function renderUserPosts(posts, container) {
    container.innerHTML = "";

    if (!posts || posts.length === 0) {
        container.innerHTML = "<p style='color:#777;'>У пользователя пока нет постов</p>";
        return;
    }

    posts.forEach(post => {
        const card = document.createElement("div");
        card.className = "post-card";

        const username = post.user?.username || "Неизвестный";
        const avatar = post.user?.imageUrl || "/images/default-avatar.png";

        card.innerHTML = `
            <div class="post-header">
                <img src="${avatar}" class="post-avatar">
                <span class="post-username">${username}</span>
            </div>

            <div class="post-content">
                ${post.content}
            </div>

            ${post.imageUrl ? `<img src="${post.imageUrl}" class="post-image">` : ""}

            <div class="post-footer">
                <span class="post-date">${new Date(post.createdAt).toLocaleString()}</span>
            </div>
        `;

        container.appendChild(card);
    });
}

function setupMessageButton(targetId, targetUsername) {
    const btn = document.getElementById("messageBtn");
    const myId = localStorage.getItem("userId");

    if (targetId == myId) {
        btn.style.display = 'none';
        return;
    }

    btn.onclick = () => {
        window.location.href = `/messages?receiverId=${targetId}`;
    };

    btn.textContent = `Написать ${targetUsername}`;
}