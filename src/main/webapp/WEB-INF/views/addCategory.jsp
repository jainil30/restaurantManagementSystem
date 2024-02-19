<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container mt-5">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Add Category</h5>
            <form id="form"  action="/admin/saveCategoryData" method="POST">
            <div class="mb-3">
                <label for="cityNameInput" class="form-label">Category Name</label>
                <input type="text" class="form-control" name="categoryName" id="cityNameInput" required>
            </div>
            <div class="mb-3">
                <label for="cityDescriptionInput" class="form-label">Category Description</label>
                <input type="text" class="form-control" name="categoryDescription" id="cityDescriptionInput" required>
            </div>
            <button class="btn btn-primary float-end">Save</button>
        </form>
        </div>
    </div>
</div>
