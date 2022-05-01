/*
---Alexsandria Ryan
---Exercise #17
---Submitted: April 11, 2022
---Grade received: 100%

Assignment description unavailable as semester has ended.
Entire file created by myself.
*/

alert("JavaScript is working");

const allEventsCells = document.getElementsByTagName("td");             //everything listed under "td" in the HTML will be 

function addEvent(item){
    const eventName = document.getElementById(item.id).innerHTML;       //Make Event Name = inner text in HTML
    document.getElementById("myReport").innerHTML += eventName + "<br>";//add event to "myReport"; add a break to go to next line
    document.getElementById(item.id).style.backgroundColor = "green";   //set Event Cell to green when clicked
    document.getElementById(item.id).style.color = "white";             //set Event Cell text to white when clicked
}

function clearMyReport(){
    document.getElementById("myReport").innerHTML = "";     //convert everything in MyReport to nothing
    for(let i = 0; i < allEventsCells.length; i++){         //for loop to search Event Cells incrementally by "i"
        allEventsCells[i].style.backgroundColor = "";       //convert the Event Cell background from green to nothing
        allEventsCells[i].style.color = "";                 //convert the Event Cell text from white to nothing
    }
}