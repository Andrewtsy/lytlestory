base_url = "http://localhost:8080/api/story/";
document.addEventListener('DOMContentLoaded', () => {
    const searchForm = document.getElementById('search-form');
    const searchInput = document.getElementById('search-input');

    if (searchForm) {
        searchForm.addEventListener('submit', function (e) {
            e.preventDefault();
            const query = searchInput.value.trim();
            if (!query) return;

            window.location.href = 'search.html?query=' + encodeURIComponent(query);
        });
    }
});