base_url = "http://localhost:8080/api/story/";

document.addEventListener('DOMContentLoaded', () => {
    const params = new URLSearchParams(window.location.search);
    const query = params.get('query');
    const resultsDiv = document.getElementById('search-results');

    fetch(base_url + 'search?query=' + encodeURIComponent(query), {
                    method: 'GET'
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(stories => {
        resultsDiv.innerHTML = '';
        if (stories.length == 0) {
            resultsDiv.innerHTML = '<p>No stories found.</p>';
        } else {
            stories.forEach(story => {
                const storyDiv = document.createElement('div');
                storyDiv.innerHTML = `
                    <div>
                        <h3>${story.title}</h3>
                        <p>Author: ${story.author}</p>
                        <p>${story.content.substring(0, 100)}...</p>
                        <a href="/story/${story.id}">Read more</a>
                    </div>
                `;
                resultsDiv.appendChild(storyDiv);
            });
        }
    })
    .catch(error => {
        console.error('Error fetching stories:', error);
        resultsDiv.innerHTML = '<p>Error fetching stories. Please try again later.</p>';
    });
});