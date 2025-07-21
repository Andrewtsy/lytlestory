base_url = "http://localhost:8080/api/story/";

const story_cells = document.querySelectorAll('.story-image');

story_cells.forEach((el) => {
    el.addEventListener('mouseenter', () => {
        el.style.transform = 'scale(1.25)';
    });
    el.addEventListener('mouseleave', () => {
        el.style.transform = 'scale(1)';
    });
});

document.addEventListener('DOMContentLoaded', () => {
    const searchForm = document.getElementById('search-form');
    const searchInput = document.getElementById('search-input');

    if (searchForm) {
        searchForm.addEventListener('submit', function (e) {
            e.preventDefault();
            console.log('Search form submitted');
            const query = searchInput.value.trim();
            if (!query) return;

            window.location.href = '/search.html?query=' + encodeURIComponent(query);
        });
    }
});