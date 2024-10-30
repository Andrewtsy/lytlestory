const story_cells = document.querySelectorAll('.story-image');

story_cells.forEach((el) => {
    el.addEventListener('mouseenter', () => {
        el.style.transform = 'scale(1.25)';
    });
    el.addEventListener('mouseleave', () => {
        el.style.transform = 'scale(1)';
    });
});