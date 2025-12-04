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
        console.log("Profile load error", res.status);
        window.location.href = "/login";
        return;
    }

    const user = await res.json();

    document.getElementById("username").textContent = user.username;
    document.getElementById("email").textContent = user.email;

    if (user.bio) {
        document.getElementById("bio").textContent = user.bio;
    }
}

document.getElementById("logoutBtn").addEventListener("click", () => {
    localStorage.removeItem("token");
    localStorage.removeItem("userId");
    window.location.href = "/login";
});
loadProfile();