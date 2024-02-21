<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container mt-5">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Add Product</h5>
            <form id="form" action="/restaurant/saveProductData" method="POST" enctype="multipart/form-data">
                <div class="mb-3 row">
                    <div class="col">
                        <label for="categorySelect" class="form-label">Category Name</label>
                        <select class="form-select" id="categorySelect" name="productCategoryName" required>
                            <c:forEach var="category" items="${categories}">
                                <option value="${category.categoryName}">${category.categoryName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col">
                        <label for="subcategorySelect" class="form-label">Subcategory Name</label>
                        <select class="form-select" id="subcategorySelect" name="productSubCategoryName" required>
                        </select>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="productNameInput" class="form-label">Product Name</label>
                    <input type="text" class="form-control" id="productNameInput" name="productName" required>
                </div>
                <div class="mb-3">
                    <label for="productPriceInput" class="form-label">Product Price</label>
                    <input type="number" class="form-control" id="productPriceInput" name="productPrice" required>
                </div>
                <div class="mb-3">
                    <label for="productDescriptionInput" class="form-label">Product Description</label>
                    <input type="text" class="form-control" id="productDescriptionInput" name="productDescription"
                        required>
                </div>
                <div class="mb-3">
                    <label for="productImageInput" class="form-label">Product Image</label>
                    <input type="file" class="form-control" id="productImageInput" name="file"  accept="image/*" required>
                </div>
                <button class="btn btn-primary float-end">Save</button>
            </form>
        </div>
    </div>
</div>