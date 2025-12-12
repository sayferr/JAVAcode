document.addEventListener('DOMContentLoaded', () => {
    const searchInput = document.getElementById('userSearchInput');
    const resultsContainer = document.getElementById('searchResults');

    if (!searchInput || !resultsContainer) {
        console.warn('Элементы поиска (userSearchInput или searchResults) не найдены.');
        return;
    }

    let searchTimer;

    searchInput.addEventListener('input', function() {
        clearTimeout(searchTimer);
        const query = this.value.trim();

        if (query.length === 0) {
            resultsContainer.style.display = 'none';
            return;
        }

        searchTimer = setTimeout(() => {
            performSearch(query);
        }, 300);
    });

    async function performSearch(query) {
        const token = localStorage.getItem("token");
        if (!token) return;

        try {
            const res = await fetch(`/api/users/search?query=${query}`, {
                headers: { "Authorization": "Bearer " + token }
            });

            if (res.ok) {
                const users = await res.json();
                renderSearchResults(users);
            } else {
                resultsContainer.style.display = 'none';
            }
        } catch (e) {
            console.error("Ошибка при поиске пользователей:", e);
        }
    }

    function renderSearchResults(users) {
        resultsContainer.innerHTML = '';

        if (users.length === 0) {
            resultsContainer.innerHTML = '<div class="search-info-item">Никого не найдено</div>';
            resultsContainer.style.display = 'block';
            return;
        }

        users.forEach(user => {
            const div = document.createElement('div');
            div.className = 'search-result-item';

            const avatar = user.imageUrl ? user.imageUrl : '/images/default-avatar.png';

            div.innerHTML = `
                <img src="${avatar}" class="search-avatar" alt="ava">
                <span class="search-username">${user.username}</span>
            `;

            div.onclick = () => {
                alert("Переход к пользователю: " + user.username + " (ID: " + user.id + ")");
                 window.location.href = `/user-profile?id=${user.id}`;
                resultsContainer.style.display = 'none';
                searchInput.value = '';
            };

            resultsContainer.appendChild(div);
        });

        resultsContainer.style.display = 'block';
    }

    document.addEventListener('click', function(e) {
        if (!searchInput.contains(e.target) && !resultsContainer.contains(e.target)) {
            resultsContainer.style.display = 'none';
        }
    });
});