const filter = document.querySelector('.topic__filter');
const dropdown = document.querySelector('.dropdown1');

filter.addEventListener('click', () => {
    dropdown.classList.toggle('toggle');
});