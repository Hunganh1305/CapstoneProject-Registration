<%-- 
    Document   : contact
    Created on : Jun 15, 2022, 8:51:03 AM
    Author     : phamquang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Contact</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Lato:700%7CMontserrat:400,600" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

        <!-- Font Awesome Icon -->
        <script src="https://kit.fontawesome.com/e7ea130b87.js" crossorigin="anonymous"></script>

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css"/>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        
        <%
            String name = (String) session.getAttribute("name");
            if (name == null) {
                response.sendRedirect("Login.jsp");
            } else {
        %>

        <!-- Header -->
        <header>
            <%@include file="header_profile.jsp" %>
        </header>
        <!-- /Header -->
        <div class="container head-title">
            <h1>Contact us</h1>
        </div>

        <!-- Contact -->
        <div id="contact" class="section">

            <!-- container -->
            <div class="container">

                <!-- row -->
                <div class="row">

                    <!-- contact form -->
                    <div class="col-md-6">
                        <div class="contact-form">
                            <h4>Send A Message</h4>
                            <form>
                                <input class="input" type="text" name="name" placeholder="Name" required="">
                                <input class="input" type="email" name="email" placeholder="Email" required="">
                                <input class="input" type="text" name="subject" placeholder="Subject" required="">
                                <textarea class="input" name="message" placeholder="Enter your Message" required=""></textarea>
                                <button type="submit" class="main-button icon-button pull-right" data-toggle="modal" data-target="#myModal">Send Message</button>
                            </form>
                        </div>
                    </div>
                    <!-- /contact form -->

                    <!-- contact information -->
                    <div class="col-md-5 col-md-offset-1">
                        <h4>Contact Information</h4>
                        <ul class="contact-details">
                            <li><i class="fa fa-envelope"></i>daihocfpt@fpt.edu.vn</li>
                            <li><i class="fa fa-phone"></i>028 7300 1866</li>
                            <li><i class="fa fa-map-marker"></i>Lô E2a-7, Đường D1 Khu Công nghệ cao, P. Long Thạnh Mỹ, TP. Thủ Đức, TP. Hồ Chí Minh</li>
                        </ul>

                        <!-- contact map -->
                        <div id="contact-map"></div>
                        <!-- /contact map -->

                    </div>
                    <!-- contact information -->

                </div>
                <!-- /row -->

            </div>
            <!-- /container -->

        </div>
        <!-- /Contact -->

        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Thank you for your message!</h4>
                    </div>
                    <div class="modal-body">
                        <p>Your request have been sent!</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="main-button icon-button pull-right" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Footer -->
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
        <!-- /Footer -->
        
        <% }
        %>

        <!-- preloader -->
        <div id='preloader'><div class='preloader'></div></div>
        <!-- /preloader -->


        <!-- jQuery Plugins -->
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
        <script type="text/javascript" src="js/google-map.js"></script>
        <script type="text/javascript" src="js/main.js"></script>

    </body>
</html>

