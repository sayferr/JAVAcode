// // post-view.js
// document.addEventListener("DOMContentLoaded", async function () {
//     const postsContainer = document.getElementById("posts-container");
//     const token = localStorage.getItem("token");
//
//     if (!token) {
//         window.location.href = "/login";
//         return;
//     }
//
//     try {
//         const response = await fetch("/api/posts/my", {
//             method: "GET",
//             headers: {
//                 "Authorization": "Bearer " + token,
//                 "Content-Type": "application/json"
//             }
//         });
//
//         if (!response.ok) {
//             console.error("Ошибка загрузки постов:", response.status);
//             if (response.status === 401 || response.status === 403) {
//                 alert("Сессия истекла");
//                 window.location.href = "/login";
//             }
//             return;
//         }
//
//         const posts = await response.json();
//         renderPosts(posts, postsContainer, true);
//
//         // навешивание обработчиков CRUD (делегирование)
//         postsContainer.addEventListener("click", async (e) => {
//             const editBtn = e.target.closest(".btn-edit");
//             const deleteBtn = e.target.closest(".btn-delete");
//
//             // if (editBtn) {
//             //     const postId = editBtn.dataset.postId;
//             //     // редирект на страницу редактирования (предполагается, что у тебя есть /edit_post/{id})
//             //     window.location.href = `/edit_post/${postId}`;
//             // }
//
//             if (deleteBtn) {
//                 const postId = deleteBtn.dataset.postId;
//                 if (!confirm("Удалить пост?")) return;
//
//                 try {
//                     const delResp = await fetch(`/api/posts/my`, {
//                         method: "DELETE",
//                         headers: {
//                             "Authorization": "Bearer " + token
//                         }
//                     });
//                     if (delResp.ok) {
//                         // успешно удалено — перезагрузим ленту
//                         const refreshed = await fetch("/api/posts/my", {
//                             headers: { "Authorization": "Bearer " + token }
//                         });
//                         const newPosts = await refreshed.json();
//                         renderPosts(newPosts, postsContainer, true);
//                     } else {
//                         alert("Не удалось удалить пост: " + delResp.status);
//                     }
//                 } catch (err) {
//                     console.error(err);
//                     alert("Ошибка при удалении");
//                 }
//             }
//         });
//
//     } catch (error) {
//         console.error("Ошибка сети:", error);
//     }
// });

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
