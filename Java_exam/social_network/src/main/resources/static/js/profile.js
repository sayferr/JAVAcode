async function loadProfile() {
    const token = localStorage.getItem("token");

    if (!token) {
        window.location.href = "/login";
        return;
    }

    const res = await fetch("/api/users/profile", {
        headers: {
            "Authorization": "Bearer " + token
        }
    });

    if (!res.ok) {
        console.log("Profile load error:", res.status);
        window.location.href = "/login";
        return;
    }

    const user = await res.json();

   if (document.getElementById("username"))
       document.getElementById("username").textContent = user.username;

   if (document.getElementById("email"))
       document.getElementById("email").textContent = user.email;

   if (document.getElementById("bio"))
       document.getElementById("bio").textContent = user.bio || "";

    // if (user.imageUrl) {
    //     document.getElementById("image").src = user.imageUrl;
    // }
    if (user.imageUrl) {
        // ИСПРАВЛЕНИЕ: Цель - элемент img с ID "profileAvatar"
        const profileImg = document.getElementById("profileAvatar");
        if (profileImg) { // Проверяем на всякий случай, что элемент найден
            profileImg.src = user.imageUrl;
        }
    }
 }

document.getElementById("logoutBtn").addEventListener("click", () => {
    localStorage.removeItem("token");
    localStorage.removeItem("userId");
    window.location.href = "/login";
});

loadProfile();