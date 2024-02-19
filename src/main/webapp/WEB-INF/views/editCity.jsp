<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Page content-->
<div class="container mt-5">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Edit City</h5>
            <form id="form"  action="/admin/updateCityData/${city.cityId}" method="POST">
                <div class="mb-3">
                    <label for="cityNameInput" class="form-label">City Name</label>
                    <input type="text" class="form-control" name="cityName" id="cityNameInput" value="${city.cityName}">
                </div>
                <div class="mb-3">
                    <label for="cityDescriptionInput" class="form-label">City Description</label>
                    <input type="text" class="form-control" id="cityDescriptionInput" name="cityDescription" value="${city.cityDescription}">
                </div>
                <button class="btn btn-primary float-end">Save</button>
            </form>
        </div>
    </div>
</div>

