<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container mt-5">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Add Offer</h5>
            <form id="form"  action="/restaurant/updateOfferData/${offer.offerId}" method="POST">
            <div class="mb-3 row">
                <div class="col">
                    <label for="categorySelect" class="form-label">Category Name</label>
                    <select class="form-select" id="categorySelect" name="offerCategoryName" value="${offer.offerCategoryName}">
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.categoryName}">${category.categoryName}</option>
                        </c:forEach>                   
                    </select>
                </div>
                <div class="col">
                    <label for="subcategorySelect" class="form-label">Subcategory Name</label>
                    <select class="form-select" id="subcategorySelect" name="offerSubCategoryName" value="${offer.offerSubCategoryName}>
                    </select>
                </div>
            </div>
            <div class="mb-3">
                <label for="offerNameInput" class="form-label">Offer Name</label>
                <input type="text" class="form-control" id="offerNameInput" name="offerName" value="${offer.offerName}" required>
            </div>
            <div class="mb-3">
                <label for="offerDescriptionInput" class="form-label">Offer Description</label>
                <input type="text" class="form-control" id="offerDescriptionInput" name="offerDescription" value="${offer.offerDescription}" required>
            </div>
            <div class="mb-3 row">
                <div class="col">
                    <label for="startDateInput" class="form-label">Start Date</label>
                    <input type="datetime-local" class="form-control" id="startDateInput"  value="${offer.offerStartDate}" name="startDate" required>
                </div>
                <div class="col">
                    <label for="endDateInput" class="form-label">End Date</label>
                    <input type="datetime-local" class="form-control" id="endDateInput" value="${offer.offerEndDate}" name="endDate" required>
                </div>
            </div>
            <div class="mb-3">
                <label for="discountInput" class="form-label">Discount (%)</label>
                <input type="number" class="form-control" id="discountInput" name="offerDiscount" value="${offer.offerDiscount}" maxlength="3" min="0" max="100" required>
            </div>
            <button class="btn btn-primary float-end">Save</button>
        </form>
        </div>
    </div>
</div>
