<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <link href="/css/styles.css" rel="stylesheet" />
<link rel="stylesheet" href="/css/jstable.css" /> -->
<div class="card m-5">
    <div class="card-body">
        <h5 class="card-title">Restaurant Details</h5>
        <div class="btn-group" role="group" aria-label="City Actions">
          <button type="button" class="btn btn-dark m-2" id="copyBtn">Copy</button>
          <button type="button" class="btn btn-primary m-2" id="csvBtn">CSV</button>
          <button type="button" class="btn btn-success m-2"  id="excelBtn">Excel</button>
          <button type="button" class="btn btn-danger m-2" id="pdfBtn">PDF</button>
          <button type="button" class="btn m-2" id="printBtn">Print</button>
        </div>
        <div class="row justify-content-end"> 

        </div>
        <table id="viewTable" class="table table-hover">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>City Name</th>
                    <th>Area Name</th>
                    <th>Restaurant Name</th>
                    <th>Restaurant <Address></Address></th>
                    <th>Phone No.</th>
                </tr>
            </thead>
                <tbody>
                    <c:forEach var="restaurant" items="${restaurants}">
                        <tr>
                            <td>${restaurant.restaurantId}</td>
                            <td>${restaurant.restaurantCity}</td>
                            <td>${restaurant.restaurantArea}</td>
                            <td>${restaurant.restaurantName}</td>
                            <td>${restaurant.restaurantAddress}</td>
                            <td>${restaurant.restaurantContactNo}</td>
                        </tr>                  
                    </c:forEach>
                 </tbody>
            <!-- <tbody>
                <tr>
                    <td>1</td>
                    <td>Bhavnagar</td>
                    <td>Vijarajnagar</td>
                    <td>UFC Uncle</td>
                    <td>Uncles Restaurant</td>
                    <td>9929452521</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Bhavnagar</td>
                    <td>Vijarajnagar</td>
                    <td>Jay Khodiyar</td>
                    <td>Jay Khodiyar Restaurant</td>
                    <td>9929452521</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Bhavnagar</td>
                    <td>Vijarajnagar</td>
                    <td>UFC Uncle</td>
                    <td>Uncles Restaurant</td>
                    <td>9929452521</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Bhavnagar</td>
                    <td>Vijarajnagar</td>
                    <td>Jay Khodiyar</td>
                    <td>Jay Khodiyar Restaurant</td>
                    <td>9929452521</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Bhavnagar</td>
                    <td>Vijarajnagar</td>
                    <td>UFC Uncle</td>
                    <td>Uncles Restaurant</td>
                    <td>9929452521</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Bhavnagar</td>
                    <td>Vijarajnagar</td>
                    <td>Jay Khodiyar</td>
                    <td>Jay Khodiyar Restaurant</td>
                    <td>9929452521</td>
                </tr> -->

            </tbody>
        </table>

    </div>
</div>
<!-- <script src="/js/jstable.js"></script>
<script>
    // console.log("Styling Table restaurantTable")
    new JSTable("#viewRestaurantTable");
</script> -->
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link href="https://unpkg.com/gridjs/dist/theme/mermaid.min.css" rel="stylesheet" />
<script src="https://unpkg.com/gridjs/dist/gridjs.umd.js"></script>
 -->