console.log("Welcome to the Community Portal");

window.onload = () => {
    alert("Page Fully Loaded");
};

let events = [];
let totalRegistrations = 0;

/* Event Class */

class Event {

    constructor(
        id,
        name,
        category,
        date,
        seats
    ){
        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
        this.seats = seats;
    }
}

/* Prototype */

Event.prototype.checkAvailability =
function(){
    return this.seats > 0;
};

/* Closure */

function registrationTracker(){

    let count = 0;

    return function(){

        count++;
        return count;
    };
}

const musicTracker =
registrationTracker();

/* Add Event */

function addEvent(event){
    events.push(event);
}

/* Register User */

function registerUser(id){

    try{

        const event =
        events.find(
        e => e.id === id
        );

        if(!event)
            throw new Error(
            "Event not found"
            );

        if(event.seats <= 0)
            throw new Error(
            "No seats available"
            );

        event.seats--;

        totalRegistrations++;

        document.getElementById(
        "registeredUsers"
        ).innerText =
        totalRegistrations;

        musicTracker();

        updateUI();

    }
    catch(error){
        alert(error.message);
    }
}

/* Filter */

function filterEventsByCategory(
category,
callback
){

    let filtered;

    if(category==="All"){
        filtered = events;
    }
    else{

        filtered =
        events.filter(
        event =>
        event.category === category
        );
    }

    callback(filtered);
}

/* UI */

function updateUI(list=events){

    const container =
    document.getElementById(
    "eventsContainer"
    );

    container.innerHTML = "";

    list.forEach(event=>{

        const card =
        document.createElement("div");

        card.className =
        "event-card";

        card.innerHTML = `

        <span class="category
        ${event.category.toLowerCase()}">

        ${event.category}

        </span>

        <h3>${event.name}</h3>

        <p>📅 ${event.date}</p>

        <p>🎟 Seats:
        ${event.seats}</p>

        <button
        onclick=
        "registerUser(${event.id})">

        Register

        </button>

        `;

        container.appendChild(card);
    });
}

/* Populate Form Dropdown */

function populateDropdown(){

    const select =
    document.getElementById(
    "eventSelect"
    );

    select.innerHTML="";

    events.forEach(event=>{

        const option =
        document.createElement(
        "option"
        );

        option.value =
        event.name;

        option.textContent =
        event.name;

        select.appendChild(option);
    });
}

/* Stats */

function updateStats(){

    document.getElementById(
    "totalEvents"
    ).innerText =
    events.length;

    const totalSeats =
    events.reduce(
    (sum,event)=>
    sum + event.seats,
    0
    );

    document.getElementById(
    "totalSeats"
    ).innerText =
    totalSeats;
}

/* Fetch Events */

async function fetchEvents(){

    document.getElementById(
    "loader"
    ).style.display =
    "block";

    try{

        const response =
        await fetch(
        "events.json"
        );

        const data =
        await response.json();

        data.forEach(item=>{

            addEvent(
            new Event(
                item.id,
                item.name,
                item.category,
                item.date,
                item.seats
            ));
        });

        console.log(
        [...events]
        );

        updateUI();

        populateDropdown();

        updateStats();

    }
    catch(error){

        console.error(error);

    }

    document.getElementById(
    "loader"
    ).style.display =
    "none";
}

/* Category Filter */

document
.getElementById(
"categoryFilter"
)
.onchange = function(){

    filterEventsByCategory(
    this.value,
    updateUI
    );
};

/* Search */

document
.getElementById(
"searchBox"
)
.addEventListener(
"keydown",
function(){

    const text =
    this.value
    .toLowerCase();

    const result =
    events.filter(
    event =>
    event.name
    .toLowerCase()
    .includes(text)
    );

    updateUI(result);
});

/* Form */

document
.getElementById(
"registrationForm"
)
.addEventListener(
"submit",
function(event){

    event.preventDefault();

    const name =
    this.elements[
    "name"
    ].value;

    const email =
    this.elements[
    "email"
    ].value;

    const selectedEvent =
    this.elements[
    "event"
    ].value;

    const error =
    document.getElementById(
    "error"
    );

    error.innerHTML = "";

    if(!name || !email){

        error.innerHTML =
        "All fields are required";

        return;
    }

    const payload = {

        name,
        email,
        selectedEvent
    };

    console.log(
    "Submitting:",
    payload
    );

    setTimeout(()=>{

        fetch(
        "https://jsonplaceholder.typicode.com/posts",
        {
            method:"POST",

            headers:{
                "Content-Type":
                "application/json"
            },

            body:
            JSON.stringify(
            payload
            )
        })

        .then(
        response =>
        response.json()
        )

        .then(data=>{

            console.log(data);

            alert(
            "Registration Successful"
            );

            $('#eventsContainer')
            .fadeOut(400)
            .fadeIn(400);

        })

        .catch(error=>{

            console.error(
            error
            );

            alert(
            "Registration Failed"
            );
        });

    },2000);
});

/* Start */

fetchEvents();