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
        window.location.href = "/login";
        return;
    }

    const user = await res.json();

    document.getElementById("username").textContent = user.username;
    document.getElementById("email").textContent = user.email;
}

document.getElementById("logoutBtn").addEventListener("click", () => {
    localStorage.removeItem("token");
    window.location.href = "/login";
});

loadProfile();