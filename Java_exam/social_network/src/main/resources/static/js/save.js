async function saveProfile() {
    const token = localStorage.getItem("token");
    const username = document.getElementById("usernameInput").value;
    const email = document.getElementById("emailInput").value;
    const bio = document.getElementById("bioInput").value;
    const password = document.getElementById("passwordInput").value;

    const image = document.getElementById("imageInput").files[0];

    const formData = new FormData();

    formData.append("data", new Blob([JSON.stringify({
        username,
        email,
        bio,
        password
    })], { type: "application/json" }));

    if (image) {
        formData.append("image", image);
    }

    const res = await fetch("/api/users/profile", {
        method: "PUT",
        headers: {
            "Authorization": "Bearer " + token
        },
        body: formData
    });

    if (!res.ok) {
        alert("Ошибка сохранения профиля");
        return;
    }

    alert("Профиль обновлён!");
    location.reload();
}

saveProfile()