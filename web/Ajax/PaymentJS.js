selectedRowToInput();
function selectedRowToInput() {
    var table = document.getElementById('table'), rIndex;
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            rIndex = this.rowIndex;
            document.getElementById("payment_id").value = this.cells[1].textContent;
            document.getElementById("appointment_id").value = this.cells[2].textContent;
            document.getElementById("amount").value = this.cells[3].textContent;
            document.getElementById("date_time").value = this.cells[4].textContent;
        };
    }
}

function save() {
    var payment_id = $('#payment_id').val();
    var appointment_id = $('#appointment_id').val();
    var amount = $('#amount').val();
    var date_time = $('#date_time').val();
    var action = "insert";
    if (payment_id === "" || appointment_id === "" || amount === "" || date_time === "") {
        alert("Please Enter All Details")
    } else {
        $.ajax({
            url: 'PaymentServlet',
            method: 'POST',
            data: {action: action, payment_id: payment_id, appointment_id: appointment_id, amount: amount, date_time: date_time},
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
    var payment_id = $('#payment_id').val();
    var appointment_id = $('#appointment_id').val();
    var amount = $('#amount').val();
    var date_time = $('#date_time').val();
    var action = "update";
    payment_id = parseInt(payment_id);
    if (payment_id === 0) {
        alert("Please Select to Update")
    } else if (payment_id === "" || appointment_id === "" || amount === "" || date_time === "") {
        alert("Please Enter All Details")
    } else {
        $.ajax({
            url: 'PaymentServlet',
            method: 'POST',
            data: {action: action, payment_id: payment_id, appointment_id: appointment_id, amount: amount, date_time: date_time},
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
    var payment_id = $('#payment_id').val();
    var action = "delete";
    payment_id = parseInt(payment_id);
    if (payment_id === 0) {
        alert("Please Select to Update")
    } else {
        var r = confirm("Are you Sure?");
        if (r == true) {
            $.ajax({
                url: 'PaymentServlet',
                method: 'POST',
                data: {action: action, payment_id: payment_id},
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
    var dropdown1 = document.getElementById('appointment_id');
    $('#appointment_id')
            .find('option')
            .remove()
            .end()
            ;

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


            if (c.length > 1) {

                var step1 = [];
                var step2 = [];
                step1 = resultText.split("~");

                for (i = 0; i < step1.length; ++i) {
                    step2 = step1[i].split("_");
                    var option = document.createElement("option");
                    option.text = step2[0];
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
    var action = "serch";
    $.ajax({
        url: 'PaymentServlet',
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
                            k = i + 1;
                    cell0.innerHTML = k;
                    cell1.innerHTML = step2[0];
                    cell2.innerHTML = step2[1];
                    cell3.innerHTML = step2[2];
                    cell4.innerHTML = step2[3];
                    cell5.innerHTML = step2[4];
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