<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Page content-->
<div class="container mt-5">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Add Area</h5>
            <form id="form"  action="/admin/saveAreaData" method="POST">
            <div class="mb-3">
                <label for="citySelect" class="form-label">Select City</label>
                <select class="form-select" id="citySelect" name="areaCityName">
                    <c:forEach var="city" items="${cities}">
                        <option value="${city.cityName}">${city.cityName}</option>    
                    </c:forEach>
                    <!-- Dropdown options will be dynamically populated here -->
                </select>
            </div>
            <div class="mb-3">
                <label for="cityNameInput" class="form-label">Area Name</label>
                <input type="text" class="form-control" name="areaName" id="cityNameInput">
            </div>
            <div class="mb-3">
                <label for="cityDescriptionInput" class="form-label">Area Description</label>
                <input type="text" class="form-control"  name="areaDescription" id="cityDescriptionInput">
            </div>
            <button class="btn btn-primary float-end">Save</button>
        </form>
        </div>
    </div>
</div>
