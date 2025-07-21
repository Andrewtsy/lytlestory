stories_url = "http://localhost:8080/api/story/";
images_url = "http://localhost:8080/uploads/images/";

document.addEventListener('DOMContentLoaded', () => {
    const params = new URLSearchParams(window.location.search);
    const query = params.get('query');
    const resultsDiv = document.getElementById('search-results');

    fetch(stories_url + 'search?query=' + encodeURIComponent(query), {
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
                console.log(`${images_url}${story.filePath}.jpg`);
                storyDiv.innerHTML = `
                    <div class="story-item">
                        <a href="/story/${story.title}">
                            <div class="story-image" style="background-image: url('${images_url}${story.filePath}.jpg');">
                            </div>
                            <div class="story-title-box">
                                <h3 class="story-title">${story.title}</h3>
                            </div>
                        </a>
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