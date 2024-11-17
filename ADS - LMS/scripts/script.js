function redirect(url) {
    window.location.href = url;
}

const menuBtn = document.querySelector('.menuBtn');
const navmenu = document.querySelector('.navmenu');
const navLabels = document.querySelectorAll('.navLabel');
const navLink = document.querySelectorAll('.navLink');
const container = document.querySelector('.container');

menuBtn.onclick = function () {
    console.log('nav toggle');
    
    // Toggle class on navmenu
    navmenu.classList.toggle('close');
    container.classList.toggle('full');
    
    // Toggle class on each navLabel element
    navLabels.forEach(label => {
        label.classList.toggle('pre-close');
    });

    navLink.forEach(link => {
        link.classList.toggle('close');
    });
};
