if(typeof window!== 'undefined')

document.addEventListener('DOMContentLoaded', function() {
    const targetImageURL = chrome.runtime.getURL('profile-pic.png');
  
    function replaceProfilePictures() {
      // Select all profile pictures in LinkedIn posts
      const profilePictures = document.querySelectorAll('img.feed-shared-actor__avatar-image');
  
      profilePictures.forEach((img) => {
        img.src = targetImageURL;
      });
    }
  
    // Initial replacement when the content script runs
    replaceProfilePictures();
  
    // Observe for changes in the DOM to handle dynamically loaded content
    const observer = new MutationObserver((mutations) => {
      mutations.forEach((mutation) => {
        if (mutation.addedNodes.length || mutation.type === 'childList') {
          replaceProfilePictures();
        }
      });
    });
  
    observer.observe(document.body, {
      childList: true,
      subtree: true
    });
  });
  
  document.addEventListener('DOMContentLoaded', function() {
    const targetImageURL = chrome.runtime.getURL('profile-pic.png');
  
    function replaceProfilePictures() {
      const profilePictures = document.querySelectorAll('img.feed-shared-actor__avatar-image');
      profilePictures.forEach((img) => {
        img.src = targetImageURL;
      });
    }
  
    function debounce(func, wait) {
      let timeout;
      return function(...args) {
        const context = this;
        clearTimeout(timeout);
        timeout = setTimeout(() => func.apply(context, args), wait);
      };
    }
  
    const debouncedReplace = debounce(replaceProfilePictures, 300);
  
    replaceProfilePictures();
  
    const observer = new MutationObserver((mutations) => {
      mutations.forEach((mutation) => {
        if (mutation.addedNodes.length || mutation.type === 'childList') {
          debouncedReplace();
        }
      });
    });
  
    observer.observe(document.body, {
      childList: true,
      subtree: true
    });
  });
  