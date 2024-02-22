<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card m-5">
  <div class="card-body">
      <h5 class="card-title">Sub Category Details</h5>
      <div class="btn-group" role="group" aria-label="City Actions">
          <button type="button" class="btn btn-dark m-2" id="copyBtn">Copy</button>
          <button type="button" class="btn btn-primary m-2" id="csvBtn">CSV</button>
          <button type="button" class="btn btn-success m-2"  id="excelBtn">Excel</button>
          <button type="button" class="btn btn-danger m-2" id="pdfBtn">PDF</button>
          <button type="button" class="btn m-2" id="printBtn">Print</button>
    </div>
    <div class="row justify-content-end"> <!-- Align items to the right -->
      <div class="col-md-2">
        <a href="/admin/addSubCategory" id="addBtn" class="btn btn-primary m-2">Add Sub Category</a>
      </div>
    </div>

   
      
  
     <table id="viewTable" class="table table-hover">
      <thead>
        <tr>
            <!-- <th>No.</th> -->
            <th>Category Name</th>
            <th>Sub Category Name</th>
            <th> Sub Category Description</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
      <c:forEach var="subCategory" items="${subCategories}">
          <tr>
              <!-- <td>${subCategory.subCategoryId}</td> -->
              <td>${subCategory.subCategoryName}</td>
              <td>${subCategory.subCategoryCategoryName}</td>
              <td>${subCategory.subCategoryDescription}</td>
              <td>
                <a class="btn btn-sm btn-outline-primary bi bi-pencil-fill" id="editBtn" href="/admin/editSubCategoryData/${subCategory.subCategoryId}">
 
                </a>
              <a class="btn btn-sm btn-outline-danger bi bi-trash-fill" href="/admin/deleteSubCategory/${subCategory.subCategoryId}" onclick="return confirm('Do you want to delete?');">

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
        <td class="descriptionColumn">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sit, quidem consectetur. Tempore ullam quas ut rerum nostrum nobis, voluptates, maiores autem itaque molestias est quam. Alias rerum pariatur quos saepe?</td>
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