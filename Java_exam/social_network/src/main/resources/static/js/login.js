document.getElementById("loginForm").addEventListener("submit", async function (e) {
    e.preventDefault();

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    const response = await fetch("/api/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password })
    });

    console.log(response);

    if (!response.ok) {
        alert("Неверные данные");
        return;
    }

    const data = await response.json();

    localStorage.setItem("token", data.token);
    localStorage.setItem("userId", data.userId);

    window.location.href = "/profile";
});