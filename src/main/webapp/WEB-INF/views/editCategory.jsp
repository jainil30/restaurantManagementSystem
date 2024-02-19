<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Page content-->
<div class="container mt-5">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Edit Category</h5>
            <form id="form"  action="/admin/updateCategoryData/${category.categoryId}" method="POST">
            <div class="mb-3">
                
                <label for="cityNameInput" class="form-label">Category Name</label>
                <input type="text" class="form-control" name="categoryName" id="cityNameInput" value="${category.categoryName}" required>
            </div>
            <div class="mb-3">
                <label for="cityDescriptionInput" class="form-label">Category Description</label>
                <input type="text" class="form-control" id="cityDescriptionInput" name="categoryDescription"  value="${category.categoryDescription}" required>
            </div>
            <button class="btn btn-primary float-end">Save</button>
        </form>
        </div>
    </div>
</div>
