<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Admin Dashboard</title>
        
        <!-- Favicon-->
        <!-- <link rel="icon" type="image/x-icon" href="/assets/favicon.ico" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"> -->
        <!-- Core theme CSS (includes Bootstrap)-->
        <!-- <link href="/static/css/styles.css" rel="stylesheet" /> -->
        <!-- <link href="/css/styles.css"  rel="stylesheet" />        
        <link rel="stylesheet" href="/css/jstable.css" />
        <link href="https://unpkg.com/gridjs/dist/theme/mermaid.min.css" rel="stylesheet" /> -->

        <!-- <script src="https://unpkg.com/gridjs/dist/gridjs.umd.js"></script> --> 
        <!-- Core theme JS-->
        <!-- <script src="/static/js/scripts.js"></script> -->
        <!-- <script src="/js/jstable.js"></script>
        <script src="/js/scripts.js"></script>         -->
        <style>
             body {
            /* background-image: url('https://images.pexels.com/photos/459469/pexels-photo-459469.jpeg?cs=srgb&dl=basil-delicious-food-459469.jpg&fm=jpg'); */
            background-size: cover;
            background-position: center;
        }
        </style>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/css/styles.css" rel="stylesheet" />
        <link rel="stylesheet" href="/css/jstable.css" />

        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        

    </head>
    <body>
        
        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light">Food Order</div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/admin/viewUserDetails"><i class="bi bi-display m-2"></i>Dashboard </i></a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/admin/viewCity"><i class="bi bi-building m-2"></i>Manage City </a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/admin/viewArea"><i class="bi bi-geo-alt-fill m-2"></i>Manage Area</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/admin/viewCategory"><i class="bi bi-cup-fill m-2"></i>Manage Category </a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/admin/viewSubCategory"><i class="bi bi-cup-hot-fill m-2"></i>Manage Sub Category</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/admin/viewRestaurant"><i class="bi bi-magic m-2"></i>Manage Restaurant</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/admin/viewOffers"><i class="bi bi-handbag-fill m-2"></i>Manage Offers</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/admin/viewComplaint"><i class="bi bi-telephone-fill m-2"></i>Manage Complaint</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/logout"><i class="bi bi-box-arrow-right m-2"></i>Logout</a>
                </div>
            </div>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <div class="container-fluid">
                        <button class="btn" id="sidebarToggle"><i class="bi bi-list"></i></button>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                        <!-- <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                                <li class="nav-item active"><a class="nav-link" href="#!">Home</a></li>
                                <li class="nav-item"><a class="nav-link" href="#!">Link</a></li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
                                    <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="#!">Action</a>
                                        <a class="dropdown-item" href="#!">Another action</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#!">Something else here</a>
                                    </div>
                                </li>
                            </ul>
                        </div> -->
                    </div>
                </nav>
                <!-- Page content-->
                <div class="container-fluid" id="page-content">
    
                </div>
            </div>
        </div>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Scripts -->
        
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
        <%-- <script type="text/javascript" src="tableExport.min.js"></script> --%>

        <%-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> --%>
        <script lang="javascript" src="https://cdn.sheetjs.com/xlsx-0.20.1/package/dist/xlsx.full.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.0/jspdf.umd.min.js" integrity="sha512-5yTVoG0jFRsDhgYEoKrZCj5Bazxqa0VnETLN7k0SazQcARBsbgrSb6um+YpzWKNKV2kjb8bhna4fDfOk3YPr4Q==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.8.0/jspdf.plugin.autotable.js" integrity="sha512-QbpHkTKy9ZZfLzC8t1TwPkopb6fQ0sq6FJ0RMpbjSz4Or53ohmZUE8Ri3JdQHCAiuw/UIYgA3XvgJ/WYcMwMMA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

        <%-- excel mate --%>
        <script src="/js/FileSaver.js"></script>
        <script src="/js/jstable.js"></script>
        <script src="/js/scripts.js" defer></script>
        <script>


        </script>

    </body>
</html>
