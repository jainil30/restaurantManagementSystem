<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card m-5">
    <div class="card-body">
        <h5 class="card-title">Add City</h5>
        <form id="form"  action="/admin/saveCityData" method="POST">
          <div class="mb-3">
              <label for="cityNameInput" class="form-label">City Name</label>
              <input type="text" class="form-control" name="cityName" id="cityNameInput">
          </div>
          <div class="mb-3">
              <label for="cityDescriptionInput" class="form-label">City Description</label>
              <input type="text" class="form-control" name="cityDescription" id="cityDescriptionInput">
          </div>
          <button class="btn btn-primary float-end">Save</button>
      </form>
    </div>
</div>
