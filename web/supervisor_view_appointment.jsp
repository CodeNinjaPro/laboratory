<%-- 
    Document   : logout
    Created on : Oct 27, 2020, 3:33:48 PM
    Author     : Roshan Withanage
--%>

<!DOCTYPE html>
<html>
    <head>
        <%
//            if (session.getAttribute("usertype") == "Supervisor") {
//                response.sendRedirect("supervisor_view_appointment.jsp");
//            } else if (session.getAttribute("usertype") == "Patient") {
//                response.sendRedirect("patient_view_appointment.jsp");
//            }
        %>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>ABC</title>
        <meta name="description" content="">
        <meta name="viewport"
              content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="robots" content="all,follow">
        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome CSS-->
        <link rel="stylesheet"
              href="vendor/font-awesome/css/font-awesome.min.css">
        <!-- Fontastic Custom icon font-->
        <link rel="stylesheet" href="css/fontastic.css">
        <!-- Google fonts - Poppins -->
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
        <!-- theme stylesheet-->
        <link rel="stylesheet" href="css/style.green.css"
              id="theme-stylesheet">
        <!-- Custom stylesheet - for your changes-->
        <link rel="stylesheet" href="css/custom.css">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/favicon.ico">
        <!-- Tweaks for older IEs-->
        <!--[if lt IE 9]>
                <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
                <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <body onload="load()">
        <div class="page">
            <!-- Main Navbar-->
            <header class="header">
                <nav class="navbar">
                    <!-- Search Box-->
                    <div class="search-box">
                        <button class="dismiss">
                            <i class="icon-close"></i>
                        </button>
                        <form id="searchForm" action="#" role="search">
                            <input type="search" placeholder="What are you looking for..."
                                   class="form-control">
                        </form>
                    </div>
                    <div class="container-fluid">
                        <div
                            class="navbar-holder d-flex align-items-center justify-content-between">
                            <!-- Navbar Header-->
                            <div class="navbar-header">
                                <!-- Navbar Brand -->
                                <a href="index.jsp"
                                   class="navbar-brand d-none d-sm-inline-block">
                                    <div class="brand-text d-none d-lg-inline-block">
                                        <span>ABC </span><strong> Laboratory</strong>
                                    </div>
                                    <div class="brand-text d-none d-sm-inline-block d-lg-none">
                                        <strong>ABC</strong>
                                    </div>
                                </a>
                                <!-- Toggle Button-->
                                <a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
                            </div>
                            <!-- Navbar Menu -->
                            <ul
                                class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">

                                <li class="nav-item"><a href="logout.jsp"
                                                        class="nav-link logout"> <span class="d-none d-sm-inline">Logout</span><i
                                            class="fa fa-sign-out"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
            <div class="page-content d-flex align-items-stretch">
                <!-- Side Navbar -->
                <nav class="side-navbar">
                    <!-- Sidebar Header-->
                    <div class="sidebar-header d-flex align-items-center">
                        <div class="avatar">
                            <img src="img/user.png" alt="..." class="img-fluid rounded-circle">
                        </div>
                        <div class="title">
                            <h1 class="h4">${userfullname}</h1>
                            <p>${usertype}</p>
                        </div>
                    </div>
                    <!-- Sidebar Navidation Menus-->
                    <span class="heading">Main</span>
                    <ul class="list-unstyled">

                        <li class="active"><a href="supervisor_view_appointment.jsp"><i class="fa fa-file-text-o"></i>Appointment</a></li>
                        <li><a href="supervisor_view_patient.jsp"><i class="fa fa-users"></i>Patient</a></li>
                        <li><a href="supervisor_view_payment.jsp"><i class="fa fa-money"></i>Payment</a></li>
                        <li><a href="supervisor_view_report.jsp"><i class="fa fa-bar-chart-o"></i>Report</a></li>
                        <li><a href="supervisor_view_doctor.jsp"><i class="fa fa-user-md"></i>Doctor</a></li></br>
                        <li><a href="logout.jsp"><i class="fa fa-sign-out"></i>Logout</a></li>
                    </ul>
                </nav>
                <div class="content-inner">
                    <!-- Page Header-->
                    <header class="page-header">
                        <div class="container-fluid">
                            <h2 class="no-margin-bottom">ABC</h2>
                        </div>
                    </header>
                    <!-- Breadcrumb-->
                    <div class="breadcrumb-holder container-fluid">
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item active">Laboratory</li>
                        </ul>
                    </div>
                    <!-- Forms Section-->

                    <section class="forms">
                        <div class="container-fluid">
                            <div class="row">

                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="card-header d-flex align-items-center">
                                            <h3 class="h4">History</h3>
                                        </div>
                                        <div class="card-body">
                                            <div class="table-responsive">
                                                <table class="table table-hover" id="table">
                                                    <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>Appointment ID</th>
                                                            <th>Patient ID</th>
                                                            <th>Doctor ID</th>
                                                            <th>Appointment Date</th>
                                                            <th>Appointment Time</th>
                                                            <th>Status</th>
                                                            <th>Date</th>
                                                        </tr>
                                                    </thead>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="card-header d-flex align-items-center">
                                            <h3 class="h4">Appointment</h3>
                                        </div>
                                        <div class="card-body">
                                            <form class="form-horizontal" id="form">
                                                <div class="form-group row">
                                                    <div class="col-sm-9">
                                                        <input id="appointment_id" type="hidden" value="0" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Patient</label>
                                                    <div class="col-sm-9">
                                                        <select id="patient_id" class="form-control form-control-warning">

                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Doctor</label>
                                                    <div class="col-sm-9">
                                                        <select id="doctor_id" class="form-control form-control-warning">

                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Appointment Date</label>
                                                    <div class="col-sm-9">
                                                        <input id="appointment_date" type="date"	placeholder="appointment date" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Appointment Time</label>
                                                    <div class="col-sm-9">
                                                        <input id="appointment_time" type="time"	placeholder="appointment time" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Status</label>
                                                    <div class="col-sm-9">
                                                        <select id="status" class="form-control form-control-warning">
                                                            <option>Pending</option>
                                                            <option>Approved</option>
                                                            <option>Cancel</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <div class="col-sm-9">
                                                        <input id="date_time" type="hidden"	value="2020" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <div class="col-sm-9 offset-sm-3">
                                                        <input onclick="save()" type="button" value="Save" class="btn btn-primary">
                                                        <input onclick="update()" type="button" value="Update" class="btn btn-primary">
                                                        <input onclick="delet()" type="button" value="Delete" class="btn btn-danger">
                                                        <input onclick="delet()" type="button" value="Report" class="btn btn-secondary">
                                                        <input type="reset" value="Reset" class="btn btn-primary">
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </section>



                    <!-- Page Footer-->
                    <footer class="main-footer">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-sm-6">
                                    <p>ABC &copy; 2017-2020</p>
                                </div>
                                <div class="col-sm-6 text-right">
                                    <p>
                                        Design by <a href="#" class="external">ABC</a>
                                    </p>
                                    <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
                                </div>
                            </div>
                        </div>
                    </footer>
                </div>
            </div>
        </div>
        <!-- JavaScript files-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/popper.js/umd/popper.min.js">

        </script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="vendor/jquery.cookie/jquery.cookie.js">

        </script>
        <script src="vendor/chart.js/Chart.min.js"></script>
        <script src="vendor/jquery-validation/jquery.validate.min.js"></script>
        <!-- Main File-->
        <script src="js/front.js"></script>


        <script type="text/javascript">
                                                            function Export() {
                                                                alert("called");
                                                                html2canvas(document.getElementById('report'), {
                                                                    onrendered: function (canvas) {
                                                                        var data = canvas.toDataURL();
                                                                        var docDefinition = {
                                                                            content: [{

                                                                                    image: data,
                                                                                    width: 500
                                                                                }]
                                                                        };
                                                                        pdfMake.createPdf(docDefinition).download("Report.pdf");
                                                                    }
                                                                });
                                                            }
                                                            $(document).ready(function () {
                                                                $("#search_table").on("keyup", function () {
                                                                    var value = $(this).val().toLowerCase();
                                                                    $("#table tr").filter(function () {
                                                                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                                                                    });
                                                                });
                                                            });
        </script>
        <script src="Ajax/ajax.js" type="text/javascript"></script>
        <script src="Ajax/AppointmentJS.js" type="text/javascript"></script>
        <script src="Ajax/Validations.js" type="text/javascript"></script>
    </body>
</html>