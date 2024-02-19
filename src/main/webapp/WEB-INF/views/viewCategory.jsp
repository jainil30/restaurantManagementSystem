<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card m-5">
  <div class="card-body">
      <h5 class="card-title">Category Details</h5>
      <div class="btn-group" role="group" aria-label="City Actions">
        <button type="button" class="btn btn-dark m-2">Copy</button>
        <button type="button" class="btn btn-primary m-2">CSV</button>
        <button type="button" class="btn btn-success m-2"  id="excelBtn">Excel</button>
        <button type="button" class="btn btn-danger m-2" id="pdfBtn">PDF</button>
        <button type="button" class="btn m-2">Print</button>
    </div>
    <div class="row justify-content-end"> <!-- Align items to the right -->
      <div class="col-md-2">
        <a href="/admin/addCategory" id="addBtn" class="btn btn-primary m-2">Add Category</a>
      </div>
    </div>

   
      
  
     <table id="viewTable" class="table table-hover">
      <thead>
        <tr>
            <th>No.</th>
            <th>Category Name</th>
            <th>Category Description</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
      <c:forEach var="category" items="${categories}">
          <tr>
              <td>${category.categoryId}</td>
              <td>${category.categoryName}</td>
              <td>${category.categoryDescription}</td>
              <td>
                <a class="btn btn-sm btn-outline-primary" id="editBtn" href="/admin/editCategoryData/${category.categoryId}">
                  <i class="bi bi-pencil-fill"></i>
                </a>
              <a class="btn btn-sm btn-outline-danger" href="/admin/deleteCategory/${category.categoryId}">
                  <i class="bi bi-trash-fill"></i>
              </a>
              </td>
                
          </tr>                  
      </c:forEach>
   </tbody>
    <!-- <tbody>
          <tr>
            <td>1</td>
            <td>Bhavnagar</td>
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