// const token = localStorage.getItem("token");
// let currentUserId = localStorage.getItem("userId");
//
// async function loadFollowStatsAndRun() {
//
//     if (!currentUserId) {
//
//         setTimeout(loadFollowStatsAndRun, 100);
//         return;
//     }
//
//     try {
//
//         const followersRes = await fetch(`/api/users/${currentUserId}/followers`, {
//             headers: { "Authorization": "Bearer " + token }
//         });
//         const followers = await followersRes.json();
//         const followersCountElement = document.getElementById("followersCount");
//         if (followersCountElement) {
//             followersCountElement.innerText = followers.length;
//         }
//
//         const followingRes = await fetch(`/api/users/${currentUserId}/following`, {
//             headers: { "Authorization": "Bearer " + token }
//         });
//         const following = await followingRes.json();
//         const followingCountElement = document.getElementById("followingCount");
//         if (followingCountElement) {
//             followingCountElement.innerText = following.length;
//         }
//
//     } catch (e) {
//         console.error("Ошибка загрузки статистики:", e);
//     }
// }
//
// document.addEventListener("DOMContentLoaded", loadFollowStatsAndRun);
//
// window.openFollowModal = async function(type) {
//     const modal = document.getElementById("followModal");
//     const listContainer = document.getElementById("modalUserList");
//     const title = document.getElementById("modalTitle");
//
//     if (!currentUserId || !token) return;
//
//     modal.style.display = "block";
//     listContainer.innerHTML = "<p>Загрузка...</p>";
//
//     let url = "";
//     if (type === 'followers') {
//         title.innerText = "Подписчики";
//         url = `/api/users/${currentUserId}/followers`;
//     } else {
//         title.innerText = "Подписки";
//         url = `/api/users/${currentUserId}/following`;
//     }
//
//
//     try {
//         const res = await fetch(url, {
//             headers: { "Authorization": "Bearer " + token }
//         });
//         const data = await res.json();
//
//         listContainer.innerHTML = "";
//
//         if (data.length === 0) {
//             listContainer.innerHTML = "<p>Список пуст</p>";
//             return;
//         }
//
//         // Асинхронно получаем данные о каждом пользователе
//         for (const item of data) {
//             const targetUserId = (type === 'followers') ? item.followerId : item.followingId;
//
//             const userRes = await fetch(`/api/users/${targetUserId}`, {
//                 headers: { "Authorization": "Bearer " + token }
//             });
//
//             if (userRes.ok) {
//                 const userDto = await userRes.json();
//                 const userElement = createUserListItem(userDto);
//                 listContainer.appendChild(userElement);
//             }
//         }
//
//     } catch (e) {
//         console.error(e);
//         listContainer.innerHTML = "<p>Ошибка загрузки списка.</p>";
//     }
// }
//
//
// // Утилита для создания HTML-элемента пользователя в списке
// function createUserListItem(user) {
//     const div = document.createElement("div");
//     div.className = "modal-user-item";
//
//     const avatar = user.imageUrl || "/images/default-avatar.png";
//
//     div.innerHTML = `<img src="${avatar}" class="modal-user-avatar" alt="ava">
//         <span class="modal-username">${user.username}</span>
//     `;
//
//     return div;
// }
//
// // Делаем функцию закрытия глобальной, чтобы ее мог вызвать HTML (onclick="closeFollowModal()")
// window.closeFollowModal = function() {
//     document.getElementById("followModal").style.display = "none";
// }
//
// // Закрыть при клике вне окна
// window.onclick = function(event) {
//     const modal = document.getElementById("followModal");
//     if (event.target == modal) {
//         modal.style.display = "none";
//     }
// }

window.openFollowModal = async function(type) {
    const modal = document.getElementById("followModal");
    const listContainer = document.getElementById("modalUserList");
    const title = document.getElementById("modalTitle");

    if (!currentUserId || !token) return;

    modal.style.display = "block";
    listContainer.innerHTML = "<p>Загрузка...</p>";

    let url = "";
    if (type === 'followers') {
        title.innerText = "Подписчики";
        url = `/api/users/${currentUserId}/followers`;   // ← ✔ Исправлено
    } else {
        title.innerText = "Подписки";
        url = `/api/users/${currentUserId}/following`;   // ← ✔ Исправлено
    }

    try {
        const res = await fetch(url, {
            headers: { "Authorization": "Bearer " + token }
        });
        const data = await res.json();

        listContainer.innerHTML = "";

        if (data.length === 0) {
            listContainer.innerHTML = "<p>Список пуст</p>";
            return;
        }

        // Загружаем данные конкретных пользователей
        for (const item of data) {
            const targetUserId = (type === 'followers')
                ? item.followerId
                : item.followingId;

            const userRes = await fetch(`/api/users/${targetUserId}`, {
                headers: { "Authorization": "Bearer " + token }
            });

            if (userRes.ok) {
                const userDto = await userRes.json();
                const userElement = createUserListItem(userDto);
                listContainer.appendChild(userElement);
            }
        }

    } catch (e) {
        console.error(e);
        listContainer.innerHTML = "<p>Ошибка загрузки списка.</p>";
    }
};