function escapeHtml(unsafe) {
    if (unsafe === null || unsafe === undefined) return "";
    return String(unsafe)
        .replaceAll("&", "&amp;")
        .replaceAll("<", "&lt;")
        .replaceAll(">", "&gt;")
        .replaceAll('"', "&quot;")
        .replaceAll("'", "&#039;");
}

function renderPosts(posts, container, showCrudButtons = false) {
    container.innerHTML = "";

    if (!posts || posts.length === 0) {
        container.innerHTML = "<p style='color: #888;'>Постов пока нет...</p>";
        return;
    }

    const currentUserId = localStorage.getItem("userId");

    posts.forEach(post => {
        const date = post.createdAt ? new Date(post.createdAt).toLocaleString() : "";

        const isOwner = currentUserId && post.user && String(currentUserId) === String(post.user.id);

        let actionsHtml = "";
        if (showCrudButtons && isOwner) {
            actionsHtml = `
                <div class="post-actions" style="margin-top: 10px; border-top: 1px solid #eee; padding-top: 5px; display: flex; justify-content: flex-end;">
                    <button class="btn-edit" data-post-id="${post.id}" style="background: #ffc107; color: #333; border: none; padding: 5px 10px; cursor: pointer; border-radius: 4px;">✏️ Редактировать</button>
                    <button class="btn-delete" data-post-id="${post.id}" style="background: #dc3545; color: white; border: none; padding: 5px 10px; margin-left: 10px; cursor: pointer; border-radius: 4px;">🗑️ Удалить</button>
                </div>
            `;
        }

        const imgHtml = post.imageUrl
            ? `<img class="post-image" src="${escapeHtml(post.imageUrl)}" alt="Post Image" style="max-width: 100%; height: auto; display: block; margin-top: 10px; border-radius: 4px;">`
            : "";

        const username = post.user?.username || "Неизвестный";
        const avatar = post.user?.imageUrl || "/images/default-avatar.png";

        const card = document.createElement("div");
        card.className = "post-card";
        card.style.cssText = "background: white; padding: 15px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); margin-bottom: 20px;";

        card.innerHTML = `
            <div class="post-header" style="display: flex; align-items: center; margin-bottom: 10px;">
                <img class="post-avatar" src="${escapeHtml(avatar)}" alt="avatar" style="width: 40px; height: 40px; border-radius: 50%; object-fit: cover; margin-right: 10px;">
                <span class="post-username" style="font-weight: bold;">${escapeHtml(username)}</span>
            </div>

            <div class="post-content" style="margin-bottom: 10px;">
                ${escapeHtml(post.content)}
            </div>

            ${imgHtml}

            <div class="post-footer" style="display: flex; justify-content: space-between; font-size: 0.9em; color: #555; margin-top: 10px;">
                <div class="post-interactions">
                    <span class="like-btn" data-post="${post.id}" style="cursor: pointer; margin-right: 15px;">
                        ❤️ <span class="likes-count">${post.likesCount || 0}</span>
                    </span>
                </div>
                <span class="post-date">${escapeHtml(date)}</span>
            </div>

            ${actionsHtml}
        `;

        container.appendChild(card);
    });
}

let editPostId = null;
let oldImageUrl = null;

document.addEventListener("click", async function(e) {

    // УДАЛЕНИЕ
    if (e.target.classList.contains("btn-delete")) {
        const id = e.target.dataset.postId;

        const res = await fetch(`/api/posts/${id}`, {
            method: "DELETE",
            headers: {
                "Authorization": "Bearer " + localStorage.getItem("token")
            }
        });

        if (res.ok) {
            location.reload();
        } else {
            console.error("Ошибка удаления", res.status);
        }
    }

    // РЕДАКТИРОВАНИЕ
    if (e.target.classList.contains("btn-edit")) {
        const id = e.target.dataset.postId;
        editPostId = id;

        const res = await fetch(`/api/posts/${id}`, {
            method: "GET",
            headers: {
                "Authorization": "Bearer " + localStorage.getItem("token")
            }
        });

        const post = await res.json();

        document.getElementById("edit-text").value = post.content;
        oldImageUrl = post.imageUrl || null;

        const preview = document.getElementById("edit-preview");
        if (oldImageUrl) {
            preview.src = oldImageUrl;
            preview.style.display = "block";
        } else {
            preview.style.display = "none";
        }

        document.getElementById("edit-modal").style.display = "flex";
    }

    document.getElementById("closeEdit").addEventListener("click", async function(){
        document.getElementById("edit-modal").style.display = "none";
    });

    // function closeEdit() {
    //     document.getElementById("edit-modal").style.display = "none";
    // }

});

document.getElementById("save-edit").addEventListener("click", async function() {
    const text = document.getElementById("edit-text").value;
    const file = document.getElementById("edit-file").files[0];

    const dto = {
        content: text
    };

    const formData = new FormData();
    formData.append("data", new Blob([JSON.stringify(dto)], { type: "application/json" }));

    if (file) {
        formData.append("image", file);
    }

    const res = await fetch(`/api/posts/${editPostId}`, {
        method: "PUT",
        headers: {
            "Authorization": "Bearer " + localStorage.getItem("token")
        },
        body: formData
    });

    if (res.ok) {
        location.reload();
    } else {
        console.error("Ошибка редактирования", res.status);
    }
});