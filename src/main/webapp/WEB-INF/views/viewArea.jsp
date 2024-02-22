<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card m-5">
  <div class="card-body">
      <h5 class="card-title">Area Details</h5>
      <div class="btn-group" role="group" aria-label="City Actions">
          <button type="button" class="btn btn-dark m-2" id="copyBtn">Copy</button>
          <button type="button" class="btn btn-primary m-2" id="csvBtn">CSV</button>
          <button type="button" class="btn btn-success m-2"  id="excelBtn">Excel</button>
          <button type="button" class="btn btn-danger m-2" id="pdfBtn">PDF</button>
          <button type="button" class="btn m-2" id="printBtn">Print</button>
    </div>
    <div class="row justify-content-end"> <!-- Align items to the right -->
      <div class="col-md-2">
        <a href="/admin/addArea" id="addBtn" class="btn btn-primary m-2">Add Area</a>
      </div>
    </div>
  <table id="viewTable" class="table table-hover">
      <thead>
        <tr>
            <!-- <th>No.</th> -->
            <th>City Name</th>
            <th>Area Name</th>
            <th>Area Description</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
      <c:forEach var="area" items="${areas}">
          <tr>
              <!-- <td>${area.areaId}</td> -->
              <td>${area.areaCityName}</td>
              <td>${area.areaName}</td>
              <td>${area.areaDescription}</td>
              <td>
                <a class="btn btn-sm btn-outline-primary bi bi-pencil-fill" href="/admin/editArea/${area.areaId}" id="editBtn">

                </a>
              <a class="btn btn-sm btn-outline-danger bi bi-trash-fill" href="/admin/deleteArea/${area.areaId}" onclick="return confirm('Do you want to delete?');">
   
              </a>
              </td>

          </tr>                  
      </c:forEach>
   </tbody>
    <!-- <tbody>
          <tr>
            <td>1</td>
            <td>Bhavnagar</td>
            <td>Vijayrajnagar</td>
            <td>Best area of Bhavnagar</td>
            <td>
              <button class="btn btn-sm btn-outline-primary">
                <i class="bi bi-pencil-fill"></i>
            </button>
            <button class="btn btn-sm btn-outline-danger">
                <i class="bi bi-trash-fill"></i>
            </button>
            </td>
          </tr>

          <tr>
            <td>1</td>
            <td>Bhavnagar</td>
            <td>Vijayrajnagar</td>
            <td>Best area of Bhavnagar</td>
            <td>
              <button class="btn btn-sm btn-outline-primary">
                <i class="bi bi-pencil-fill"></i>
            </button>
            <button class="btn btn-sm btn-outline-danger">
                <i class="bi bi-trash-fill"></i>
            </button>
            </td>
          </tr>
          <tr>
            <td>1</td>
            <td>Bhavnagar</td>
            <td>Vijayrajnagar</td>
            <td>Best area of Bhavnagar</td>
            <td>
              <button class="btn btn-sm btn-outline-primary">
                <i class="bi bi-pencil-fill"></i>
            </button>
            <button class="btn btn-sm btn-outline-danger">
                <i class="bi bi-trash-fill"></i>
            </button>
            </td>
          </tr>
          <tr>
            <td>1</td>
            <td>Bhavnagar</td>
            <td>Vijayrajnagar</td>
            <td>Best area of Bhavnagar</td>
            <td>
              <button class="btn btn-sm btn-outline-primary">
                <i class="bi bi-pencil-fill"></i>
            </button>
            <button class="btn btn-sm btn-outline-danger">
                <i class="bi bi-trash-fill"></i>
            </button>
            </td>
          </tr>
          <tr>
            <td>1</td>
            <td>a</td>
            <td>Vijayrajnagar</td>
            <td>Best area of Bhavnagar</td>
            <td>
              <button class="btn btn-sm btn-outline-primary">
                <i class="bi bi-pencil-fill"></i>
            </button>
            <button class="btn btn-sm btn-outline-danger">
                <i class="bi bi-trash-fill"></i>
            </button>
            </td>
          </tr>
          <tr>
            <td>1</td>
            <td>b</td>
            <td>Vijayrajnagar</td>
            <td>Best area of Bhavnagar</td>
            <td>
              <button class="btn btn-sm btn-outline-primary">
                <i class="bi bi-pencil-fill"></i>
            </button>
            <button class="btn btn-sm btn-outline-danger">
                <i class="bi bi-trash-fill"></i>
            </button>
            </td>
          </tr>
          <tr>
            <td>1</td>
            <td>c</td>
            <td>Vijayrajnagar</td>
            <td>Best area of Bhavnagar</td>
            <td>
              <button class="btn btn-sm btn-outline-primary">
                <i class="bi bi-pencil-fill"></i>
            </button>
            <button class="btn btn-sm btn-outline-danger">
                <i class="bi bi-trash-fill"></i>
            </button>
            </td>
          </tr>
    </tbody> -->
      </table>
      
  </div>
</div>
