// async function loadProfile() {
//     const token = localStorage.getItem("token");
//
//     if (!token) {
//         window.location.href = "/login";
//         return;
//     }
//
//     const res = await fetch("/api/users/profile", {
//         headers: {
//             "Authorization": "Bearer " + token
//         }
//     });
//
//     if (!res.ok) {
//         console.log("Profile load error:", res.status);
//         window.location.href = "/login";
//         return;
//     }
//
//     const user = await res.json();
//
//     if (user.id) {
//         localStorage.setItem("userId", user.id);
//     }
//
//     if (document.getElementById("username"))
//         document.getElementById("username").textContent = user.username;
//     if (document.getElementById("email"))
//         document.getElementById("email").textContent = user.email;
//     if (document.getElementById("bio"))
//         document.getElementById("bio").textContent = user.bio || "";
//     if (user.imageUrl) {
//         const profileImg = document.getElementById("profileAvatar");
//         if (profileImg) {
//             profileImg.src = user.imageUrl;
//         }
//     }
// }
//
// document.getElementById("logoutBtn").addEventListener("click", () => {
//     localStorage.removeItem("token");
//     localStorage.removeItem("userId");
//     window.location.href = "/login";
// });
//
// loadProfile();
async function loadProfile() {
    const token = localStorage.getItem("token");

    if (!token) {
        window.location.href = "/login";
        return;
    }

    const res = await fetch("/api/users/profile", {
        headers: { "Authorization": "Bearer " + token }
    });

    if (!res.ok) {
        console.log("Profile load error:", res.status);
        window.location.href = "/login";
        return;
    }

    const user = await res.json();

    if (user.id) {
        localStorage.setItem("userId", user.id);
    }

    document.querySelectorAll(".username").forEach(u => {
        u.textContent = user.username;
    });

    const emailEl = document.querySelector(".email");
    if (emailEl) emailEl.textContent = user.email;

    const avatar = document.getElementById("profileAvatar");
    if (avatar) {
        avatar.src = user.imageUrl && user.imageUrl.trim() !== ""
            ? user.imageUrl
            : "/images/default-avatar.png";
    }
}

document.getElementById("logoutBtn").addEventListener("click", () => {
    localStorage.removeItem("token");
    localStorage.removeItem("userId");
    window.location.href = "/login";
});

loadProfile();