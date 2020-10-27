//name validation
function validateName(evt) {
    var theEvent = evt || window.event;
    // Handle paste
    if (theEvent.type === 'paste') {
        key = event.clipboardData.getData('text/plain');
    } else {
        // Handle key press
        var key = theEvent.keyCode || theEvent.which;
        key = String.fromCharCode(key);
    }
    var regex = /^[a-zA-Z\s]+$/;
    if (!regex.test(key)) {
        theEvent.returnValue = false;
        if (theEvent.preventDefault)
            theEvent.preventDefault();
    }

}

////contact number validation
//function contactValidation() {
//    var contactNo = $('#contact').val();
//    if (contactNo.length === 10) {
//        return false;
//    } else {
//        alert("Invalid Contact Number");
//        document.getElementById("contact").select();
//        return true;
//    }
//}

//only number validation
function validateNumber(evt) {
    var theEvent = evt || window.event;
    // Handle paste
    if (theEvent.type === 'paste') {
        key = event.clipboardData.getData('text/plain');
    } else {
        // Handle key press
        var key = theEvent.keyCode || theEvent.which;
        key = String.fromCharCode(key);
    }
    var regex = /[0-9]|\./;
    if (!regex.test(key)) {
        theEvent.returnValue = false;
        if (theEvent.preventDefault)
            theEvent.preventDefault();
    }

}


//function nicValidation() {
//    var nic_no = $('#nic').val();
//
//
//    if (nic_no.length === 12) {
//        if (nic_no.includes("V") || nic_no.includes("v")) {
//            swal("Invalid NIC Number!", "Please Enter Valid NIC", "error")
//                    .then((value) => {
//                        document.getElementById("nic").select();
//                    });
//            return true;
//        } else {
//            return false;
//        }
//    } else if (nic_no.length === 10) {
//        if (nic_no.includes("V") || nic_no.includes("v")) {
//            return false;
//        } else {
//            swal("Invalid NIC Number!", "Please Enter Valid NIC", "error")
//                    .then((value) => {
//                        document.getElementById("nic").select();
//                    });
//            return true;
//        }
//    } else {
//        swal("Invalid NIC Number!", "Please Enter Valid NIC", "error")
//                .then((value) => {
//                    document.getElementById("nic").select();
//                });
//        return true;
//    }
//
//}

//nic validation
function validateNIC(evt) {
    var theEvent = evt || window.event;

    // Handle paste
    if (theEvent.type === 'paste') {
        key = event.clipboardData.getData('text/plain');
    } else {
        // Handle key press
        var key = theEvent.keyCode || theEvent.which;
        key = String.fromCharCode(key);
    }
    var regex = /[0-9-Vv]|\./;
    if (!regex.test(key)) {
        theEvent.returnValue = false;
        if (theEvent.preventDefault)
            theEvent.preventDefault();
    }

}

function onClickValidationContactNumber(evt) {
    var theEvent = evt || window.event;
    // Handle paste
    if (theEvent.type === 'paste') {
        key = event.clipboardData.getData('text/plain');
    } else {
        // Handle key press
        var key = theEvent.keyCode || theEvent.which;
        key = String.fromCharCode(key);
    }
    var regex = /[0-9]/;
    if (!regex.test(key)) {
        theEvent.returnValue = false;
        if (theEvent.preventDefault)
            theEvent.preventDefault();
    }

}

////Email validation
//function ValidateEmail() {
//
//    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($('#email').val()))
//    {
//        return false;
//    }
//    alert("Invalid Email Address");
//    document.getElementById("email").select();
//    return true;
//
//}