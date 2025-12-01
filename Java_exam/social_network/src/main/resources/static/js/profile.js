async function loadProfile() {
    const token = localStorage.getItem("token");
    if (!token) {
        window.location.href = "/login";
        return;
    }

    const res = await fetch("/api/users/me", {
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

document.getElementById("logoutBtn").onclick = () => {
    localStorage.removeItem("token");
    window.location.href = "/login";
};

loadProfile();

//
import { authFetch } from "/js/auth.js";

authFetch("/api/users/me")
    .then(res => {
        if (res.status === 403) window.location.href = "/login";
        return res.json();
    })
    .then(user => {
        document.getElementById("username").textContent = user.username;
    });