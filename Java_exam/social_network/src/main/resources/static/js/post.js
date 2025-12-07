// async function likePost(postId, el) {
//     const token = localStorage.getItem("token");
//     const userId = localStorage.getItem("userId"); // Нужно брать ID текущего юзера
//
//     if (!token || !userId) {
//         window.location.href = "/login";
//         return;
//     }
//
//     try {
//         // ВАЖНО: Добавили ?userId=${userId} в URL
//         const res = await fetch(`/api/posts/${postId}/like?userId=${userId}`, {
//             method: "POST",
//             headers: { "Authorization": "Bearer " + token }
//         });
//
//         if (res.status === 403 || res.status === 401) {
//             localStorage.removeItem("token");
//             window.location.href = "/login";
//             return;
//         }
//
//         // Перезагружаем ленту, чтобы обновить счетчик
//         await loadFeed();
//     } catch (e) {
//         console.error(e);
//     }
// }

document.addEventListener("DOMContentLoaded", async function () {

    const postsContainer = document.getElementById("posts-container");

    // ❗ у тебя раньше был accessToken — но логин сохранял token
    const token = localStorage.getItem("token");

    if (!token) {
        window.location.href = "/login";
        return;
    }

    try {
        const response = await fetch("/api/posts/user/${userId}", {
            method: "GET",
            headers: {
                "Authorization": "Bearer " + token,
                "Content-Type": "application/json"
            }
        });

        if (!response.ok) {
            console.error("Ошибка загрузки постов:", response.status);

            if (response.status === 401 || response.status === 403) {
                alert("Сессия истекла");
                window.location.href = "/login";
            }
            return;
        }

        const posts = await response.json();
        renderPosts(posts);

    } catch (error) {
        console.error("Ошибка сети:", error);
    }

    // ---------- ОТРИСОВКА ПОСТОВ ----------
    function renderPosts(posts) {

        postsContainer.innerHTML = "";

        if (posts.length === 0) {
            postsContainer.innerHTML = "<p>Постов пока нет...</p>";
            return;
        }

        posts.forEach(post => {

            const postElement = document.createElement("div");
            postElement.classList.add("post-card");

            // Проверка на картинку
            const imageHtml = post.imageUrl
                ? `<img src="${post.imageUrl}" class="post-image" alt="Post image">`
                : "";

            postElement.innerHTML = `
                <div class="post-header">
                    <h3>Пост #${post.id}</h3>
                    <span class="post-date">${new Date(post.createdAt).toLocaleString()}</span>
                </div>

                <div class="post-content">
                    <p>${post.content}</p>
                    ${imageHtml}
                </div>

                <div class="post-footer">
                    <button class="btn-like">❤️ Лайк</button>
                    <button class="btn-comment">💬 Комментарий</button>
                </div>
            `;

            postsContainer.appendChild(postElement);
        });
    }
});