<%-- 
    Document   : login
    Created on : Oct 27, 2020, 2:48:06 PM
    Author     : Roshan Withanage
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Register</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="robots" content="all,follow">
        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome CSS-->
        <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
        <!-- Fontastic Custom icon font-->
        <link rel="stylesheet" href="css/fontastic.css">
        <!-- Google fonts - Poppins -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
        <!-- theme stylesheet-->
        <link rel="stylesheet" href="css/style.green.css" id="theme-stylesheet">
        <!-- Custom stylesheet - for your changes-->
        <link rel="stylesheet" href="css/custom.css">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/favicon.ico">
        <!-- Tweaks for older IEs--><!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <body>
        <div class="page login-page">
            <div class="container d-flex align-items-center">
                <div class="form-holder has-shadow">
                    <div class="row">
                        <!-- Logo & Information Panel-->
                        <div class="col-lg-6">
                            <div class="info d-flex align-items-center">
                                <div class="content">
                                    <div class="logo">
                                        <h1>Register</h1>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Form Panel    -->
                        <div class="col-lg-6 bg-white">
                            <div class="form d-flex align-items-center">
                                <div class="content">
                                    <form class="form-horizontal" action="RegisterServlet" method="POST">
                                        <div class="form-group row">
                                            <label class="col-sm-3 form-control-label">Name</label>
                                            <div class="col-sm-9">
                                                <input name="name" type="text"	placeholder="name" class="form-control form-control-warning" required>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-3 form-control-label">Address</label>
                                            <div class="col-sm-9">
                                                <input name="address" type="text"	placeholder="address" class="form-control form-control-warning" required>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-3 form-control-label">DOB</label>
                                            <div class="col-sm-9">
                                                <input name="dob" type="text"	placeholder="dob" class="form-control form-control-warning" required>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-3 form-control-label">NIC</label>
                                            <div class="col-sm-9">
                                                <input name="nic" type="text"	placeholder="nic" class="form-control form-control-warning" required>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-3 form-control-label">Contact</label>
                                            <div class="col-sm-9">
                                                <input name="contact" type="text"	placeholder="contact" class="form-control form-control-warning" required>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-3 form-control-label">Email</label>
                                            <div class="col-sm-9">
                                                <input name="email" type="text"	placeholder="email" class="form-control form-control-warning" required>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-3 form-control-label">Username</label>
                                            <div class="col-sm-9">
                                                <input name="username" type="text"	placeholder="username" class="form-control form-control-warning" required>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-3 form-control-label">Password</label>
                                            <div class="col-sm-9">
                                                <input name="password" type="text"	placeholder="password" class="form-control form-control-warning" required>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-9 offset-sm-3">
                                                <input type="submit" value="Register" class="btn btn-primary">
                                                <input type="reset" value="Reset" class="btn btn-primary">
                                            </div>
                                        </div>
                                    </form><small>Have an account? </small><a href="login.jsp" class="signup">Signin</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyrights text-center">
                <p>Design by <a href="h#" class="external">ABC</a>
                    <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
                </p>
            </div>
        </div>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!-- Main File-->
        <script src="js/front.js"></script>
      
    </body>
</html>
