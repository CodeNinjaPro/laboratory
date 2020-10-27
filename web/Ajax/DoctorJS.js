selectedRowToInput();
function selectedRowToInput() {
    var table = document.getElementById('table'), rIndex;
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            rIndex = this.rowIndex;
            document.getElementById("doctor_id").value = this.cells[1].textContent;
            document.getElementById("name").value = this.cells[2].textContent;
            document.getElementById("specialization").value = this.cells[3].textContent;
            document.getElementById("available_days").value = this.cells[4].textContent;
            document.getElementById("available_time").value = this.cells[5].textContent;
            document.getElementById("email").value = this.cells[6].textContent;
            document.getElementById("contact").value = this.cells[7].textContent;
            document.getElementById("date_time").value = this.cells[8].textContent;
        };
    }
}

function save() {
    var doctor_id = $('#doctor_id').val();
    var name = $('#name').val();
    var specialization = $('#specialization').val();
    var available_days = $('#available_days').val();
    var available_time = $('#available_time').val();
    var email = $('#email').val();
    var contact = $('#contact').val();
    var date_time = $('#date_time').val();
    var action = "insert";
    if (doctor_id === "" || name === "" || specialization === "" || available_days === "" || available_time === "" || email === "" || contact === "" || date_time === "") {
        alert("Please Enter All Details")
    } else if (contactValidation() || ValidateEmail()) {

    } else {
        $.ajax({
            url: 'DoctorServlet',
            method: 'POST',
            data: {action: action, doctor_id: doctor_id, name: name, specialization: specialization, available_days: available_days, available_time: available_time, email: email, contact: contact, date_time: date_time},
            success: function (resultText) {
                alert(resultText);
                $("#table").find("tr:gt(0)").remove();
                load();
            },
            error: function (jqXHR, exception) {
                alert("Fail Ajax");
            }
        });
    }
}

function update() {
    var doctor_id = $('#doctor_id').val();
    var name = $('#name').val();
    var specialization = $('#specialization').val();
    var available_days = $('#available_days').val();
    var available_time = $('#available_time').val();
    var email = $('#email').val();
    var contact = $('#contact').val();
    var date_time = $('#date_time').val();
    var action = "update";
    doctor_id = parseInt(doctor_id);
    if (doctor_id === 0) {
        alert("Please Select to Update")
    } else if (doctor_id === "" || name === "" || specialization === "" || available_days === "" || available_time === "" || email === "" || contact === "" || date_time === "") {
        alert("Please Enter All Details")
    } else if (contactValidation() || ValidateEmail()) {

    } else {
        $.ajax({
            url: 'DoctorServlet',
            method: 'POST',
            data: {action: action, doctor_id: doctor_id, name: name, specialization: specialization, available_days: available_days, available_time: available_time, email: email, contact: contact, date_time: date_time},
            success: function (resultText) {
                alert(resultText);
                $("#table").find("tr:gt(0)").remove();
                load();
            },
            error: function (jqXHR, exception) {
                alert("Fail Ajax");
            }
        });
    }
}

function delet() {
    var doctor_id = $('#doctor_id').val();
    var action = "delete";
    doctor_id = parseInt(doctor_id);
    if (doctor_id === 0) {
        alert("Please Select to Update")
    } else {
        var r = confirm("Are you Sure?");
        if (r == true) {
            $.ajax({
                url: 'DoctorServlet',
                method: 'POST',
                data: {action: action, doctor_id: doctor_id},
                success: function (resultText) {
                    $("#table").find("tr:gt(0)").remove();
                    load();
                    alert("Deleted")
                },
                error: function (jqXHR, exception) {
                    alert("Fail Ajax");
                }
            });
        } else {
            alert("Not Deleted")
        }
    }
}

function load() {
    var table = document.getElementById('table');
    var action = "serch";
    $.ajax({
        url: 'DoctorServlet',
        method: 'POST',
        data: {action: action},
        success: function (resultText) {
            resultText = resultText.replace("[", "");
            resultText = resultText.replace("]", "");
            var c = [];
            c = resultText;
            if (c.length > 5) {
                var step1 = [];
                var step2 = [];
                step1 = resultText.split("~");
                for (i = 0; i < step1.length; ++i) {
                    step2 = step1[i].split("_");
                    var newRow = table.insertRow(table.length),
                            cell0 = newRow.insertCell(0),
                            cell1 = newRow.insertCell(1),
                            cell2 = newRow.insertCell(2),
                            cell3 = newRow.insertCell(3),
                            cell4 = newRow.insertCell(4),
                            cell5 = newRow.insertCell(5),
                            cell6 = newRow.insertCell(6),
                            cell7 = newRow.insertCell(7),
                            cell8 = newRow.insertCell(8),
                            cell9 = newRow.insertCell(9),
                            k = i + 1;
                    cell0.innerHTML = k;
                    cell1.innerHTML = step2[0];
                    cell2.innerHTML = step2[1];
                    cell3.innerHTML = step2[2];
                    cell4.innerHTML = step2[3];
                    cell5.innerHTML = step2[4];
                    cell6.innerHTML = step2[5];
                    cell7.innerHTML = step2[6];
                    cell8.innerHTML = step2[7];
                    cell9.innerHTML = step2[8];
                }
            }
            selectedRowToInput();
        },
        error: function (jqXHR, exception) {
            alert("Fail Ajax")
        }
    });
    document.getElementById("form").reset();
}

//contact number validation
function contactValidation() {
    var contactNo = $('#contact').val();
    if (contactNo.length === 10) {
        return false;
    } else {
        alert("Invalid Contact Number");
        document.getElementById("contact").select();
        return true;
    }
}

//Email validation
function ValidateEmail() {

    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($('#email').val()))
    {
        return false;
    }
    alert("Invalid Email Address");
    document.getElementById("email").select();
    return true;
}