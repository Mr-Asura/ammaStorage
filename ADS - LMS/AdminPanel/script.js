let currentDate = new Date();

document.addEventListener("DOMContentLoaded", () => {
    renderCalendar(currentDate);
});

function renderCalendar(date) {
    const daysDiv = document.getElementById("days");
    const monthYear = document.getElementById("month-year");

    // Clear previous days
    daysDiv.innerHTML = "";

    const year = date.getFullYear();
    const month = date.getMonth();

    // Get today's date to check for the current day
    const today = new Date();
    const isCurrentMonth = today.getFullYear() === year && today.getMonth() === month;
    const currentDay = today.getDate();

    const firstDay = new Date(year, month, 1).getDay();
    const daysInMonth = new Date(year, month + 1, 0).getDate();
    const months = [
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    ];

    // Update month and year display
    monthYear.textContent = `${months[month]} ${year}`;

    // Create empty spaces for days before the 1st of the month
    for (let i = 0; i < firstDay; i++) {
        const emptyDiv = document.createElement("div");
        emptyDiv.classList.add("empty");
        daysDiv.appendChild(emptyDiv);
    }

    // Fill in the days of the month
    for (let day = 1; day <= daysInMonth; day++) {
        const dayDiv = document.createElement("div");
        dayDiv.textContent = day;

        // Check if this is the current day and the current month
        if (isCurrentMonth && day === currentDay) {
            dayDiv.classList.add("current-day"); // Apply the "current-day" class
        }

        daysDiv.appendChild(dayDiv);
    }
}



function changeMonth(offset) {
    currentDate.setMonth(currentDate.getMonth() + offset);
    renderCalendar(currentDate);
}
