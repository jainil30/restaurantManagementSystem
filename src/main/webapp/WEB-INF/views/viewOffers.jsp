<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="card m-5">
    <div class="card-body">
        <h5 class="card-title">Offer Details</h5>
        <div class="btn-group" role="group" aria-label="City Actions">
          <button type="button" class="btn btn-dark m-2" id="copyBtn">Copy</button>
          <button type="button" class="btn btn-primary m-2" id="csvBtn">CSV</button>
          <button type="button" class="btn btn-success m-2"  id="excelBtn">Excel</button>
          <button type="button" class="btn btn-danger m-2" id="pdfBtn">PDF</button>
          <button type="button" class="btn m-2" id="printBtn">Print</button>
        </div>

        <sec:authorize access="hasRole('ROLE_RESTAURANT')">
        <div class="row justify-content-end" > <!-- Align items to the right -->
            <div class="col-md-2">
                <a href="/restaurant/addOffer" id="addBtn" class="btn btn-primary m-2">Add Offer</a>
            </div>
        </div>
         </sec:authorize>
        <table id="viewTable" class="table table-hover">
            <thead>
                <tr>
                    <!-- <th>No.</th> -->
                    <th>Restaurant</th>
                    <th>Offer Name</th>
                    <th>Offer Discount</th>
                    <th>Product</th>
                    <th>Starts from </th>
                    <th>End </th>
                    <sec:authorize access="hasRole('ROLE_RESTAURANT')">
                    <th>Action</th>
                    </sec:authorize>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="offer" items="${offers}">
                    <tr>
                        <!-- <td>${offer.offerId}</td> -->
                        <td>${offer.offerRestaurant}</td>
                        <td>${offer.offerName}</td>
                        <td>${offer.offerDiscount}</td>
                        <td>${offer.offerCategoryName} - ${offer.offerSubCategoryName}</td>
                        <td>${offer.offerStartDate}</td>
                        <td>${offer.offerEndDate}</td>
                        <sec:authorize access="hasRole('ROLE_RESTAURANT')">
                        <td>
                            <a class="btn btn-sm btn-outline-primary bi bi-pencil-fill" href="/restaurant/editOffer/${offer.offerId}" id="editBtn"></a>
                            <a class="btn btn-sm btn-outline-danger bi bi-trash-fill" href="/restaurant/deleteOffer/${offer.offerId}" onclick="return confirm('Do you want to delete?');"></a>
                        </td>
                        </sec:authorize>
                    </tr>                  
                </c:forEach>
             </tbody>
            <!-- <tbody>
                <tr>
                    <td>1</td>
                    <td>UFC</td>
                    <td>Solid Sunday</td>
                    <td>40%</td>
                    <td>Manchuran</td>
                    <td>2024-02-16 18:04:00</td>
                    <td>2025-03-16 10:04:00 </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Jay Khodiyar</td>
                    <td>Weekend Ka Wow</td>
                    <td>50%</td>
                    <td>Noodles</td>
                    <td>2024-02-16 18:04:00</td>
                    <td>2025-03-16 10:04:00 </td>
                </tr>
            </tbody> -->
        </table>

    </div>
</div>