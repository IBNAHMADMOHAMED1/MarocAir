let numberOfAdults = 1;
let numberOfStudent = 0;
let total = 1;
// let number = 0;
// let adultNums =


window.onload = () => {
    document.getElementById("adultNumber").textContent = numberOfAdults;
    document.getElementById("addingBar").style.display = "none";
}

const addNumber = (number, element) => {
    if (total <= 1) {
        total = 1;
    }else {
    element.textContent = number;
        document.getElementById("totalPassengers").textContent = total;

    }

    console.log(total);
}

const subsTrack = (person, currentElement) => {

    if (total === 1) total = 1;
    switch (person) {
        case "Adults" :
            numberOfAdults -= 1;
            if (numberOfAdults <= 1) numberOfAdults = 1;
            total -= 1;
            addNumber(numberOfAdults, currentElement)
            break;
        case "Students" :
            numberOfStudent -= 1;
            total -= 1;
            if (numberOfStudent < 0) numberOfStudent = 0;
            addNumber(numberOfStudent, currentElement)
            break;
    }


}
const addtional = (person, currentElement) => {
    switch (person) {
        case "Adults" :
            numberOfAdults += 1;
            total += 1;
            addNumber(numberOfAdults, currentElement)
            break;
        case "Students" :
            numberOfStudent += 1;
            total += 1;
            addNumber(numberOfStudent, currentElement)
            break;
    }

}

document.getElementById("open").onclick = () => {
    document.getElementById("addingBar").style.display = "block";
}
document.getElementById("backgroundOverlay").onclick = () => {
    document.getElementById("addingBar").style.display = "none";
}
