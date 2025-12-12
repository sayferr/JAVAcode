document.addEventListener("DOMContentLoaded", () => {
    loadFollowCounts();
    setupFollowButton();
});

async function loadFollowCounts() {
    const token = localStorage.getItem("token");
    const userId = localStorage.getItem("userId");

    if (!userId) return;

    const followersRes = await fetch(`/api/users/${userId}/followers`, {
        headers: { "Authorization": "Bearer " + token }
    });
    if (followersRes.ok) {
        const followers = await followersRes.json();
        document.getElementById("followersCount").textContent = followers.length;
    }

    const followingRes = await fetch(`/api/users/${userId}/following`, {
        headers: { "Authorization": "Bearer " + token }
    });
    if (followingRes.ok) {
        const following = await followingRes.json();
        document.getElementById("followingCount").textContent = following.length;
    }
}

function setupFollowButton() {
    const btn = document.getElementById("followBtn");
    if (!btn) return;

    btn.addEventListener("click", toggleFollow);
    updateFollowButtonState();
}

async function updateFollowButtonState() {
    const token = localStorage.getItem("token");
    const myId = Number(localStorage.getItem("userId"));
    const profileId = Number(document.body.dataset.profileId);

    if (!profileId || !myId || myId === profileId) return;

    const res = await fetch(`/api/users/${profileId}/followers`, {
        headers: { "Authorization": "Bearer " + token }
    });

    if (!res.ok) return;

    const followers = await res.json();
    const already = followers.some(f => f.followerId === myId);

    const btn = document.getElementById("followBtn");
    btn.textContent = already ? "Отписаться" : "Подписаться";
    btn.dataset.following = already ? "true" : "false";
}

async function toggleFollow() {
    const token = localStorage.getItem("token");
    const myId = Number(localStorage.getItem("userId"));
    const profileId = Number(document.body.dataset.profileId);

    const btn = document.getElementById("followBtn");
    const following = btn.dataset.following === "true";

    try {
        if (!following) {
            // Подписаться
            await fetch(`/api/users/${profileId}/follow?followerId=${myId}`, {
                method: "POST",
                headers: { "Authorization": "Bearer " + token }
            });
        } else {
            // Отписаться
            await fetch(`/api/users/${profileId}/follow?followerId=${myId}`, {
                method: "DELETE",
                headers: { "Authorization": "Bearer " + token }
            });
        }

        updateFollowButtonState();
        loadFollowCounts();

    } catch (e) {
        console.error("Ошибка follow:", e);
    }
}

async function openFollowModal(type) {
    const token = localStorage.getItem("token");
    const userId = Number(localStorage.getItem("userId"));

    const modal = document.createElement("div");
    modal.className = "follow-modal";

    const isFollowers = type === "followers";
    const url = isFollowers
        ? `/api/users/${userId}/followers`
        : `/api/users/${userId}/following`;

    const res = await fetch(url, {
        headers: { "Authorization": "Bearer " + token }
    });

    let list = [];
    if (res.ok) list = await res.json();

    modal.innerHTML = `
        <div class="follow-modal-box"><h3>${isFollowers ? "Подписчики" : "Подписки"}</h3>
            <button class="close-follow-modal">✖</button>
            <div class="follow-list">
                ${list.length === 0
        ? "<p class='empty'>Нет данных</p>"
        : list.map(user => `<div class="follow-item">ID: ${user.followerId ?? user.followingId}</div>`).join("")}
            </div>
        </div>
    `;

    document.body.appendChild(modal);

    modal.querySelector(".close-follow-modal").onclick = () => modal.remove();
}