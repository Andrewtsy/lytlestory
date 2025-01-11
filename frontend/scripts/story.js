console.log("JavaScript file loaded successfully");

async function getStory() {
    url = "http://localhost:8080/api/story/1"
    try {
        const response = await fetch(url, { method: 'GET' });
        const story = await response.json();

        const titleDiv = document.getElementById('title');
        const authorDiv = document.getElementById('author');

        const titleContent = story.title;
        const authorContent = story.author;

        console.log("test");

        titleDiv.textContent = titleContent;
        authorDiv.textContent = authorContent;

    } catch (error) {
        console.error('error');
    }
}

getStory()