<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Restaurant Dashboard</title>
        
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

        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

        <link href="/css/styles.css" rel="stylesheet" />
        <link rel="stylesheet" href="/css/jstable.css" />

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.js"></script>
        <script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.min.js"></script>
       
        

    </head>
    <body>
        
        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light"> <span class="material-symbols-outlined"></span>Food Order</div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3"><i class="bi bi-display m-2"></i>Dashboard </i></a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/restaurant/viewProduct"><i class="bi bi-building m-2"></i>Manage Product</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/restaurant/viewOffers"><i class="bi bi-handbag-fill m-2"></i>Manage Offers</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/restaurant/viewOrder"><i class="bi bi-geo-alt-fill m-2"></i>Manage Orders</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="/restaurant/complaints"><i class="bi bi-telephone-fill m-2"></i>Manage Complaint</a>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <!-- Scripts -->
        <%-- Excel mate --%>
        <script lang="javascript" src="https://cdn.sheetjs.com/xlsx-0.20.1/package/dist/xlsx.full.min.js"></script>
        <script src="/js/jstable.js"></script>
        <script src="/js/FileSaver.js"></script>
        <script src="/js/scripts.js"></script>
        <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
        <script>

        </script>
    </body>
</html>
