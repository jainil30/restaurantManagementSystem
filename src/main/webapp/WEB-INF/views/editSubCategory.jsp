<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Page content-->
<div class="container mt-5">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Edit Sub Category</h5>
            <form id="form"  action="/admin/updateSubCategoryData/${subCategory.subCategoryId}" method="POST">
                <div class="mb-3">
                    <label for="SubCategorySelect" class="form-label">Select Category</label>
                    <select class="form-select" id="SubCategorySelect" name="subCategoryCategoryName" >
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.categoryName}">${category.categoryName}</option>    
                        </c:forEach>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="SubCategoryNameInput" class="form-label">Sub Category Name</label>
                    <input type="text" class="form-control" name="subCategoryName" id="SubCategoryNameInput" value="${subCategory.subCategoryName}">
                </div>
                <div class="mb-3">
                    <label for="SubCategoryDescriptionInput" class="form-label">Sub Category Description</label>
                    <input type="text" class="form-control" name="subCategoryDescription" id="SubCategoryDescriptionInput" value="${subCategory.subCategoryDescription}">
                </div>
                <button class="btn btn-primary float-end">Save</button>
        </form>
        </div>
    </div>
</div>

