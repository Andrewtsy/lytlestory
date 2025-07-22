console.log("JavaScript file loaded successfully!");

async function getStory() {
    base_url = "http://localhost:8080/api/story/"
    try {
        const params = new URLSearchParams(window.location.search);
        const id_ = params.get('id');
        if (!id_) {
            console.error('No story ID provided in the URL');
            return;
        }
        url = base_url + id_;

        const response = await fetch(url, { method: 'GET' });
        const story = await response.json();

        titleElement = document.getElementsByTagName("title");
        const titleDiv = document.getElementById('title');
        const authorDiv = document.getElementById('author');
        const contentDiv = document.getElementById('main-content');

        const titleContent = story.title;
        const authorContent = story.author;
        const contentContent = story.content;

        titleElement[0].innerText = titleContent;
        titleDiv.textContent = titleContent;
        authorDiv.textContent = authorContent;
        contentDiv.innerHTML = contentContent;

    } catch (error) {
        console.error('error');
    }
}

getStory()