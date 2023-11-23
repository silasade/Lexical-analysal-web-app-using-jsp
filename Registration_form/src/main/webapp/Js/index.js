/**
 * 
 */
const textContainer = document.getElementById("text-container");
const textToType = "This is a JSP WEB APP that checks if the lexicon inputted is not a script of either javascript or SQL queries and submits if they are not.";
let index = 0;

function typeText() {
    textContainer.textContent = textToType.slice(0, index);
    index++;

    if (index <= textToType.length) {
        setTimeout(typeText, 100); // Adjust the typing speed (e.g., 100 milliseconds)
    } else {
        // Reset the animation when it reaches the end
        index = 0;
        setTimeout(typeText, 1000); // Delay before starting the animation again (e.g., 1 second)
    }
}
function event(){
	const first = document.getElementById("firstname");
    const last = document.getElementById("lastname");
    const other = document.getElementById("othername");
    const email = document.getElementById("email");
    const password = document.getElementById("password");
    const comment = document.getElementById("liveAlertBtn");
    const address = document.getElementById("address");
    other.addEventListener("input", function () {
    	if (other.value.length > 0) {
            other.style.borderColor = "green"; // Set the border color to black
            document.getElementById("other-error").innerText = ""; // Clear the error message
            document.getElementsByClassName("other")[0].style.visibility="hidden"
        }
    });
    
    first.addEventListener("input", function () {
    	if (first.value.length > 0) {
            first.style.borderColor = "green"; // Set the border color to black
            document.getElementById("first-error").innerText = ""; // Clear the error message
            document.getElementsByClassName("first")[0].style.visibility="hidden"
        }
    });
    last.addEventListener("input", function () {
    	if (last.value.length > 0) {
           last.style.borderColor = "green"; // Set the border color to black
            document.getElementById("last-error").innerText = ""; // Clear the error message
            document.getElementsByClassName("last")[0].style.visibility="hidden"
        }
    });
    email.addEventListener("input", function () {
    	if (email.value.length > 0) {
            email.style.borderColor = "green"; // Set the border color to black
            document.getElementById("email-error").innerText = ""; // Clear the error message
            document.getElementsByClassName("email")[0].style.visibility="hidden"
        }
    });
    comment.addEventListener("input", function () {
    	if (comment.value.length > 0) {
            comment.style.borderColor = "green"; // Set the border color to black
            document.getElementById("comment-error").innerText = ""; // Clear the error message
            document.getElementsByClassName("comment")[0].style.visibility="hidden"
        }
    });
    password.addEventListener("input", function () {
    	if (password.value.length > 0) {
            password.style.borderColor = "green"; // Set the border color to black
            document.getElementById("password-error").innerText = ""; // Clear the error message
            document.getElementsByClassName("password")[0].style.visibility="hidden"
        }
    });
    address.addEventListener("input", function () {
    	if (address.value.length > 0) {
    		address.style.borderColor = "green"; // Set the border color to black
            document.getElementById("address-error").innerText = ""; // Clear the error message
            document.getElementsByClassName("address")[0].style.visibility="hidden"
        }
    });
}
function validator(){
	const first = document.getElementById("firstname");
    const last = document.getElementById("lastname");
    const other = document.getElementById("othername");
    const email = document.getElementById("email");
    const password = document.getElementById("password");
    const comment = document.getElementById("liveAlertBtn");
    const address = document.getElementById("address");
    if (other.value.length < 1) {
        other.style.borderColor = "red"; // Set the border color to red
        document.getElementById("other-error").innerText="Enter your other names"
        document.getElementsByClassName("other")[0].style.visibility="visible"
        return false;
    }
    else if (first.value.length < 1) {
    	first.style.borderColor = "red"; // Set the border color to red
    	document.getElementById("first-error").innerText="Enter your first name"
    	document.getElementsByClassName("first")[0].style.visibility="visible"
        return false;
    }
    else if (last.value.length < 1) {
    	last.style.borderColor = "red"; // Set the border color to red
    	document.getElementById("last-error").innerText="Enter your other names"
    	document.getElementsByClassName("last")[0].style.visibility="visible"
        return false;
    }
    else if (email.value.length < 1) {
    	email.style.borderColor = "red"; // Set the border color to red
    	document.getElementById("email-error").innerText="Enter your Email Address"
    	document.getElementsByClassName("email")[0].style.visibility="visible"
        return false;
    }
    else if (address.value.length < 1) {
    	address.style.borderColor = "red"; // Set the border color to red
    	document.getElementById("address-error").innerText="Enter your Address"
    	document.getElementsByClassName("address")[0].style.visibility="visible"
        return false;
    }
    else if (comment.value.length < 1) {
    	comment.style.borderColor = "red"; // Set the border color to red
    	document.getElementById("comment-error").innerText="Enter your Comment"
    	document.getElementsByClassName("comment")[0].style.visibility="visible"
        return false;
    }
    else if (password.value.length < 1) {
    	password.style.borderColor = "red"; // Set the border color to red
    	document.getElementById("password-error").innerText="Enter your Password"
    	document.getElementsByClassName("password")[0].style.visibility="visible"
        return false;
    }
	return true;
}
// Start the typing animation
typeText();
event();