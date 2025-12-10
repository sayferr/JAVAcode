document.addEventListener("DOMContentLoaded", async function () {
    const postsContainer = document.getElementById("posts-container");

    try {
        const response = await fetch("/api/posts/my", {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        });

        if (!response.ok) {
            console.error("Ошибка загрузки постов:", response.status);
            return;
        }

        const posts = await response.json();
        renderPosts(posts, postsContainer, true);

    } catch (error) {
        console.error("Ошибка сети:", error);
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

    function renderPosts(posts, container, showCrudButtons) {
        container.innerHTML = "";
        if (!posts || posts.length === 0) {
            container.innerHTML = "<p style='color: #888;'>Постов пока нет...</p>";
            return;
        }

        posts.forEach(post => {
            const date = new Date(post.createdAt).toLocaleString();
            const card = document.createElement("div");
            card.className = "post-card";

            let actionsHtml = "";
            if (showCrudButtons) {
                actionsHtml = `
                    <div class="post-actions">
                        <button class="btn-edit" data-post-id="${post.id}">Редактировать</button>
                        <button class="btn-delete" data-post-id="${post.id}">Удалить</button>
                    </div>
                `;
            }

            const imgHtml = post.imageUrl
                ? `<img src="${post.imageUrl}" class="post-image">`
                : "";

            card.innerHTML = `
                <div class="post-header">
                    <span>${post.user.username}</span>
                    <span>${date}</span>
                </div>
                <div class="post-content">
                    <p>${escapeHtml(post.content)}</p>
                    ${imgHtml}
                </div>
                ${actionsHtml}
            `;

            container.appendChild(card);
        });
    }
});
