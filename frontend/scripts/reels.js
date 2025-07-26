base_url = "http://localhost:8080/api/recommender/recommend"
user_id = 0;
num_stories = 16;

async function fillReelsPage() {
    const reelsDivs = document.getElementsByClassName('story-reel');
    if (reelsDivs.length === 0) {
        return;
    }
    for (let i = 0; i < reelsDivs.length; i++) {
        const reelsDiv = reelsDivs[i];
        await populateReels(reelsDiv, user_id, num_stories);
    }
}


async function populateReels(reelsDiv, user_id, num_stories) {
    try {
        subject = reelsDiv.querySelector('.subject').textContent;
        query = djb2Hash(subject);
        scrollDiv = reelsDiv.querySelector('.story-scroll');
        scrollDiv.innerHTML = '';

        const response = await fetch(`${base_url}?query=${query}&numberOfStories=${num_stories}`, { method: 'GET' });
        const reelsMetas = await response.json();

        reelsMetas.forEach(item => {
            const itemDiv = document.createElement('div');
            itemDiv.className = 'story-item';
            itemDiv.innerHTML = `
                <a href="story.html?id=${item.id}">
                    <div class="story-image" style="background-image: url('http://localhost:8080/uploads/images/${item.file_name}.jpg');">
                    </div>
                    <div class="story-title-box">
                        <h3 class="story-title">${item.title}</h3>
                    </div>
                </a>
            `;
            scrollDiv.appendChild(itemDiv);
        });

    } catch (error) {
        console.error('Error fetching reels items:', error);
    }
}

function djb2Hash(str) {
    let hash = 5381;
    for (let i = 0; i < str.length; i++) {
        hash = ((hash << 5) + hash) + str.charCodeAt(i);
    }
    return hash >>> 0;
}


fillReelsPage();