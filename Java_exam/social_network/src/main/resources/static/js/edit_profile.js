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
        if (res.status === 403 || res.status === 401) {
            localStorage.removeItem("token");
            window.location.href = "/login";
        }
        return;
    }

    const user = await res.json();

    if (document.getElementById("username")) document.getElementById("username").value = user.username;
    if (document.getElementById("email")) document.getElementById("email").value = user.email;
    if (document.getElementById("bio")) document.getElementById("bio").value = user.bio || "";

    if (user.imageUrl) {
        const avatarImg = document.getElementById("image");
        avatarImg.src = user.imageUrl;
        avatarImg.style.display = "block";
    }
}

document.getElementById("saveBtn").addEventListener("click", async () => {
    const token = localStorage.getItem("token");

    const dto = {
        username: document.getElementById("username").value,
        email: document.getElementById("email").value,
        bio: document.getElementById("bio").value,
        password: ""
    };

    const formData = new FormData();
    formData.append("data", new Blob([JSON.stringify(dto)], { type: "application/json" }));

    const img = document.getElementById("avatar").files[0];
    if (img) formData.append("image", img);

    const res = await fetch("/api/users/profile", {
        method: "PUT",
        headers: {
            "Authorization": "Bearer " + token
        },
        body: formData
    });

    if (!res.ok) {
        alert("Ошибка сохранения! Код: " + res.status);
        return;
    }

    alert("Сохранено!");
    window.location.href = "/profile";
});

document.getElementById("cancelBtn").addEventListener("click", () => {
    window.location.href = "/profile";
});

loadProfile();