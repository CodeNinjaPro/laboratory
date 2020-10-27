selectedRowToInput();
function selectedRowToInput() {
    var table = document.getElementById('table'), rIndex;
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            rIndex = this.rowIndex;
            document.getElementById("appointment_id").value = this.cells[1].textContent;
            document.getElementById("patient_id").value = this.cells[2].textContent;
            document.getElementById("doctor_id").value = this.cells[3].textContent;
            document.getElementById("appointment_date").value = this.cells[4].textContent;
            document.getElementById("appointment_time").value = this.cells[5].textContent;
            document.getElementById("status").value = this.cells[6].textContent;
            document.getElementById("date_time").value = this.cells[7].textContent;
        };
    }
}

function save() {
    var appointment_id = $('#appointment_id').val();
    var patient_id = $('#patient_id').val();
    var doctor_id = $('#doctor_id').val();
    var appointment_date = $('#appointment_date').val();
    var appointment_time = $('#appointment_time').val();
    var status = $('#status').val();
    var date_time = $('#date_time').val();
    var action = "insert";

    var today = new Date();
    var tadaydate = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
    var sdy = appointment_date.split('-');
    var tdy = tadaydate.split('-');

    var date1 = new Date(sdy[1], sdy[0] - 1, sdy[2]);
    var date2 = new Date(tdy[1], tdy[0] - 1, tdy[2]);

    var DifferenceTime = date1.getTime() - date2.getTime();
    var DifferenceDays = DifferenceTime / (1000 * 3600 * 24);

    if (DifferenceDays == 0) {
        DifferenceDays = 1;
    }


    if (appointment_id === "" || patient_id === "" || doctor_id === "" || appointment_date === "" || appointment_time === "" || status === "" || date_time === "") {
        alert("Please Enter All Details")
    } else if (DifferenceDays < 0) {
        alert("Invlid Dates, you can't reserve past dates");
    } else {
        $.ajax({
            url: 'AppointmentServlet',
            method: 'POST',
            data: {action: action, appointment_id: appointment_id, patient_id: patient_id, doctor_id: doctor_id, appointment_date: appointment_date, appointment_time: appointment_time, status: status, date_time: date_time},
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
    var appointment_id = $('#appointment_id').val();
    var patient_id = $('#patient_id').val();
    var doctor_id = $('#doctor_id').val();
    var appointment_date = $('#appointment_date').val();
    var appointment_time = $('#appointment_time').val();
    var status = $('#status').val();
    var date_time = $('#date_time').val();
    var action = "update";

    var today = new Date();
    var tadaydate = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
    var sdy = appointment_date.split('-');
    var tdy = tadaydate.split('-');

    var date1 = new Date(sdy[1], sdy[0] - 1, sdy[2]);
    var date3 = new Date(tdy[1], tdy[0] - 1, tdy[2]);

    var DifferenceTime = date1.getTime() - date3.getTime();
    var DifferenceDays = DifferenceTime / (1000 * 3600 * 24);

    if (DifferenceDays == 0) {
        DifferenceDays = 1;
    }

    appointment_id = parseInt(appointment_id);
    if (appointment_id === 0) {
        alert("Please Select to Update")
    } else if (appointment_id === "" || patient_id === "" || doctor_id === "" || appointment_date === "" || appointment_time === "" || status === "" || date_time === "") {
        alert("Please Enter All Details")
    } else if (Difference_In_Days < 0) {
        alert("Invlid Dates, you can't reserve past dates");
    } else {
        $.ajax({
            url: 'AppointmentServlet',
            method: 'POST',
            data: {action: action, appointment_id: appointment_id, patient_id: patient_id, doctor_id: doctor_id, appointment_date: appointment_date, appointment_time: appointment_time, status: status, date_time: date_time},
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
    var appointment_id = $('#appointment_id').val();
    var action = "delete";
    appointment_id = parseInt(appointment_id);
    if (appointment_id === 0) {
        alert("Please Select to Update")
    } else {
        var r = confirm("Are you Sure?");
        if (r == true) {
            $.ajax({
                url: 'AppointmentServlet',
                method: 'POST',
                data: {action: action, appointment_id: appointment_id},
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
    var dropdown1 = document.getElementById('patient_id');
    $('#patient_id')
            .find('option')
            .remove()
            .end()
            ;

    var action = "serch";
    $.ajax({
        url: 'PatientServlet',
        method: 'POST',
        data: {action: action},
        success: function (resultText) {

            resultText = resultText.replace("[", "");
            resultText = resultText.replace("]", "");

            var c = [];
            c = resultText;


            if (c.length > 1) {

                var step1 = [];
                var step2 = [];
                step1 = resultText.split("~");

                for (i = 0; i < step1.length; ++i) {
                    step2 = step1[i].split("_");
                    var option = document.createElement("option");
                    option.text = step2[1];
                    option.value = step2[0];
                    dropdown1.add(option);

                }
            }

            onChangeDiscount();

        },
        error: function (jqXHR, exception) {
            swal("fail");
        }
    });
    var dropdown2 = document.getElementById('doctor_id');
    $('#doctor_id')
            .find('option')
            .remove()
            .end()
            ;

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


            if (c.length > 1) {

                var step1 = [];
                var step2 = [];
                step1 = resultText.split("~");

                for (i = 0; i < step1.length; ++i) {
                    step2 = step1[i].split("_");
                    var option = document.createElement("option");
                    option.text = step2[1];
                    option.value = step2[0];
                    dropdown2.add(option);

                }
            }

            onChangeDiscount();

        },
        error: function (jqXHR, exception) {
            swal("fail");
        }
    });
    var action = "serch";
    $.ajax({
        url: 'AppointmentServlet',
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