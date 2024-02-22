<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card m-5">
    <div class="card-body">
        <h5 class="card-title">Product Details</h5>
        <div class="btn-group" role="group" aria-label="City Actions">
          <button type="button" class="btn btn-dark m-2" id="copyBtn">Copy</button>
          <button type="button" class="btn btn-primary m-2" id="csvBtn">CSV</button>
          <button type="button" class="btn btn-success m-2"  id="excelBtn">Excel</button>
          <button type="button" class="btn btn-danger m-2" id="pdfBtn">PDF</button>
          <button type="button" class="btn m-2" id="printBtn">Print</button>
        </div>
        <div class="row justify-content-end"> <!-- Align items to the right -->
            <div class="col col-md-2">
                <a id="addBtn" class="btn btn-primary m-2" href="/restaurant/addProduct" >Add Product</a>
            </div>  
        </div>
        <table id="viewTable" class="table table-hover">
            <thead>
                <tr>
                    <!-- <th>No.</th> -->
                    <th>Category Name</th>
                    <th>Sub Category Name</th>
                    <th>Product Name</th>
                    <th>Product Image</th>
                    <th>Product Price</th>
                    <th>Product Description</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <!-- <td>${product.productId}</td> -->
                        <td>${product.productCategoryName}</td>
                        <td>${product.productSubCategoryName}</td>
                        <td>${product.productName}</td>
                        <td style="text-align: center;"><a href="/restaurant/viewProductImage/${product.productImageUrl}" class="bi bi-eye-fill" ></a></td>
                        <td>${product.productPrice}</td>
                        <td>${product.productDescription}</td>
                        <td>
                            <a class="btn btn-sm btn-outline-primary bi bi-pencil-fill" href="/restaurant/editProduct/${product.productId}" id="editBtn"></a>
                          <a class="btn btn-sm btn-outline-danger bi bi-trash-fill" href="/restaurant/deleteProduct/${product.productId}" onclick="return confirm('Do you want to delete?');"></a>
                        </td>
                    </tr>                  
                </c:forEach>
               
             </tbody>
            <!-- <tbody>
                <tr>
                    <th>1</th>
                    <th>Vegetarian</th>
                    <th>South-Indian</th>
                    <th>Dosa</th>
                    <th><a href=""><i class="bi bi-eye-fill"></i></a></th>
                    <th>Rs. 130</th>
                    <th>South-Indian dish</th>
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
                    <th>1</th>
                    <th>Vegetarian</th>
                    <th>South-Indian</th>
                    <th>Dosa</th>
                    <th><a href=""><i class="bi bi-eye-fill"></i></a></th>
                    <th>Rs. 130</th>
                    <th>South-Indian dish</th>
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
                    <th>1</th>
                    <th>Vegetarian</th>
                    <th>South-Indian</th>
                    <th>Dosa</th>
                    <th><a href=""><i class="bi bi-eye-fill"></i></a></th>
                    <th>Rs. 130</th>
                    <th>South-Indian dish</th>
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

<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<!-- Core theme CSS (includes Bootstrap)-->
<link href="/css/styles.css" rel="stylesheet" />
<link rel="stylesheet" href="/css/jstable.css" />

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Scripts -->
<script src="/js/jstable.js"></script>
<script src="/js/scripts.js"></script>
<script>
    new JSTable("#viewTable")
</script>
