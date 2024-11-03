console.log("JavaScript file loaded successfully");

const url = "http://localhost:8080/api/story/1"

async function getStory() {
    try {
        const response = await fetch(url, { method: 'GET' });
        const story = await response.json();
        console.log(story.title);

        const titleDiv = document.getElementById('title');
        const authorDiv = document.getElementById('author');

        const titleContent = story.title;
        const authorContent = story.author;

        titleDiv.textContent = titleContent;
        authorDiv.textContent = authorContent;

    } catch (error) {
        console.error('error');
    }
}

getStory()