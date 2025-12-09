document.addEventListener('DOMContentLoaded', () => {
    const publishButton = document.getElementById('publishBtn');
    if (publishButton) {
        publishButton.addEventListener('click', createPost);
    }
});

async function createPost() {
    // 1. Получаем данные
    const token = localStorage.getItem('token');
    const userIdString = localStorage.getItem('userId'); // Получаем как строку

    // 2. Проверка авторизации
    if (!token || !userIdString) {
        alert("Ошибка авторизации. Войдите снова.");
        window.location.href = "/login";
        return;
    }

    // КРИТИЧЕСКОЕ ИСПРАВЛЕНИЕ: Преобразуем ID в целое число (Long)
    const userId = parseInt(userIdString, 10);

    if (isNaN(userId)) {
        alert("Ошибка ID пользователя. Войдите заново, чтобы пересохранить ID.");
        window.location.href = "/login";
        return;
    }

    const content = document.getElementById('postContent').value;
    const fileInput = document.getElementById('postImage');
    const file = fileInput.files[0];

    if (!content.trim() && !file) {
        alert("Напишите текст или добавьте фото!");
        return;
    }

    // 3. Собираем JSON объект (DTO)
    const postDto = {
        content: content,
        userId: userId // Теперь это чистое число
    };

    // 4. Создаем FormData
    const formData = new FormData();

    // Добавляем JSON как Blob
    formData.append('data', new Blob([JSON.stringify(postDto)], {
        type: 'application/json'
    }));

    // Добавляем картинку, если она есть
    if (file) {
        formData.append('image', file);
    }

    try {
        const response = await fetch('/api/posts', {
            method: 'POST',
            headers: {
                'Authorization': 'Bearer ' + token
                // Content-Type указывать НЕ НАДО
            },
            body: formData
        });

        if (response.ok) {
            alert("Пост успешно создан!");
            window.location.href = "/profile";
        } else {
            console.error("Ошибка:", response.status);
            alert("Ошибка при создании поста. Код: " + response.status);
        }
    } catch (error) {
        console.error("Ошибка сети:", error);
        alert("Не удалось соединиться с сервером.");
    }
}