console.log("JavaScript file loaded successfully");

async function getStory() {
    url = "http://localhost:8080/api/story/3"
    try {
        const response = await fetch(url, { method: 'GET' });
        const story = await response.json();

        const titleDiv = document.getElementById('title');
        const authorDiv = document.getElementById('author');
        const genreDiv = document.getElementById('genre');

        const titleContent = story.title;
        const authorContent = story.author;
        const genreContent = story.genre;

        titleDiv.textContent = titleContent;
        authorDiv.textContent = authorContent;
        genreDiv.textContent = genreContent;

    } catch (error) {
        console.error('error');
    }
}

getStory()