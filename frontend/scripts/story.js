console.log("JavaScript file loaded successfully!");

async function getStory() {
    base_url = "http://localhost:8080/api/story/"
    try {
        const id_ = document.getElementById("id_").innerText;
        url = base_url + id_;

        const response = await fetch(url, { method: 'GET' });
        const story = await response.json();

        const titleDiv = document.getElementById('title');
        const authorDiv = document.getElementById('author');
        const contentDiv = document.getElementById('main-content');

        const titleContent = story.title;
        const authorContent = story.author;
        const contentContent = story.content;

        console.log("test");

        titleDiv.textContent = titleContent;
        authorDiv.textContent = authorContent;
        contentDiv.innerHTML = contentContent;

    } catch (error) {
        console.error('error');
    }
}

getStory()