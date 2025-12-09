document.addEventListener("DOMContentLoaded", async function () {

    const postsContainer = document.getElementById("posts-container");

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
})