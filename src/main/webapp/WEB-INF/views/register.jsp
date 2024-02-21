<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: url('/assets/background.jpg');
            /* background-image: url('assets\background.jpg'); */
            background-size: cover;
            background-position: center;
        }
        .card {
            margin-top: 100px;
        }
    </style>
    <%-- <script type="module" src="/js/Validator.js"></script> --%>

</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title text-center">Register Your Restaurant</h5>
                        <%-- <springForm:form action="/registerRestaurant" method="POST" id="registerRestaurant" cssClass="needs-validation" modelAttribute="restaurant" novalidate="novalidate">
                            <div class="mb-3">
                                <label for="restaurantName" class="form-label">Restaurant Name</label>
                                <springForm:input path="restaurantName" cssClass="form-control" id="restaurantName" required="required"/>
                                <div class="invalid-feedback">
                                    Please select a valid Name.
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col">
                                    <label for="restaurantEmail" class="form-label">Email</label>
                                    <springForm:input path="restaurantEmail" cssClass="form-control" id="restaurantEmail" required="required" data-email="data-email" data-email-error="Email address is invalid." />
                                    <div class="invalid-feedback">
                                        Please select a valid email.
                                    </div>
                                </div>
                                <div class="col">
                                    <label for="restaurantContactNo" class="form-label">Contact No</label>
                                    <springForm:input path="restaurantContactNo" cssClass="form-control" id="restaurantContactNo" type="number" min="0000000000" max="9999999999" required="required"/>
                                    <div class="invalid-feedback">
                                        Please enter a valid contact number.
                                    </div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="restaurantAddress" class="form-label">Address</label>
                                <springForm:input path="restaurantAddress" cssClass="form-control" id="restaurantAddress" required="required"/>
                            </div>
                            <div class="row mb-3">
                                <div class="col">
                                    <label for="restaurantCity" class="form-label">City</label>
                                    <springForm:select path="restaurantCity" cssClass="form-select" id="city" required="required">
                                        <c:forEach var="city" items="${cities}">
                                            <springForm:option value="${city.cityName}">${city.cityName}</springForm:option>
                                        </c:forEach>
                                    </springForm:select>
                                </div>
                                <div class="col">
                                    <label for="restaurantArea" class="form-label">Area</label>
                                    <springForm:select path="restaurantArea" cssClass="form-select" id="restaurantArea" required="required">
                                        <c:forEach var="area" items="${areas}">
                                            <c:if test="${area.areaCityName eq restaurantCity}">
                                                <springForm:option value="${area.areaName}">${area.areaName}</springForm:option>
                                            </c:if>
                                        </c:forEach>
                                    </springForm:select>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="restaurantPassword" class="form-label">New Password</label>
                                <springForm:password path="restaurantPassword" cssClass="form-control" id="restaurantPassword" minlength="8" placeholder="Password" required="required"/>
                                <div class="invalid-feedback"></div>
                            </div>
                            <div class="mb-3">
                                <label for="confirmPassword" class="form-label">Confirm Password</label>
                                <input type="password" class="form-control" id="confirmPassword" minlength="8" required="required" data-match="#restaurantPassword" data-match-error="Password and Confirm Password do not match" />
                                <div class="invalid-feedback"></div>
                            </div>

                            <div class="mb-3 text-center">
                                <button type="submit" id="registerBtn" class="btn btn-primary btn-block">Register</button>
                            </div>
                        </springForm:form> --%>
                       <form action="/registerRestaurant" method="post" id="registerRestaurant" class="needs-validation">
                            <div class="mb-3">
                                <label for="restaurantName" class="form-label">Restaurant Name</label>
                                <input type="text" class="form-control" id="restaurantName" name="restaurantName" minlength="6" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters" required>
                                <div class="invalid-feedback">
                                    Please select a valid Name.
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col">
                                    <label for="email" class="form-label">Email</label>
                                    <input type="email" class="form-control" id="email" name="restaurantEmail" required data-email data-email-error="Email address is invalid." required/>
                                    <div class="invalid-feedback">
                                        Please select a valid email.
                                    </div>
                                </div>
                                <div class="col">
                                    <label for="contactNo" class="form-label">Contact No</label>
                                    <input type="number" class="form-control"  min="1000000000" max="9999999999" id="contactNo" name="restaurantContactNo" required>
                                    <div class="invalid-feedback">
                                        Please enter a valid contact number.
                                    </div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="address" class="form-label">Address</label>
                                <input type="text" class="form-control" id="address" name="restaurantAddress" required>
                            </div>
                            <div class="row mb-3">
                                <div class="col">
                                    <label for="city" class="form-label">City</label>
                                    <select class="form-select" id="city" name="restaurantCity" required>
                                        <c:forEach var="city" items="${cities}">
                                            <option value="${city.cityName}">${city.cityName}</option>    
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col">
                                    <label for="area" class="form-label">Area</label>
                                    <select class="form-select" id="area" name="restaurantArea" required> 
                                        <%-- <c:forEach var="area" items="${areas}">
                                            <c:if test="${area.areaCityName eq restaurantCity}">
                                                <option value="${area.areaName}">${area.areaName}</option>
                                            </c:if>
                                        </c:forEach> --%>
                                </select>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="newPassword" class="form-label">New Password:</label>
                                <input type="password" class="form-control" id="newPassword" name="restaurantPassword"  minlength="8" placeholder="Password" required/>
                                <div class="invalid-feedback"></div>
                            </div>
                            <div class="mb-3">
                                <label for="confirmPassword" class="form-label">Confirm Password:</label>
                                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" minlength="8" required data-match="#newPassword" data-match-error="Password and Confirm Password do not match" />
                            </div>

                            <div class="mb-3 text-center">
                                <button type="submit" id="registerBtn" class="btn btn-primary btn-block">Register</button>
                            </div>
                        </form> 
                        <p class="text-center mt-3">Already Registered? <a href="/login">Login</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Sweet alert ni link -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <%-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js" integrity="sha512-WMEKGZ7L5LWgaPeJtw9MBM4i5w5OSBlSjTjCtSnvFJGSVD26gE5+Td12qN5pvWXhuWaWcVwF++F7aqu9cvqP0A==" crossorigin="anonymous" referrerpolicy="no-referrer"></script> --%>
    <script src="/js/scripts.js"></script>
    <script>

/*
    var validator = new Validator(document.querySelector("registerRestaurant"), function(){
        console.log("Validating form");
    });
    document.getElementById("registerBtn").addEventListener("click", function(event){
            event.preventDefault();
    
            var form = document.getElementById("registerRestaurant");
        
            Swal.fire({
                title: "Good job!",
                text: document.forms["registerRestaurant"]["restaurantName"].value + " is registered",
                icon: "success"
            });

            form.submit();
    }); 
   
*/
/*
        function validateForm() {
            var username = document.getElementById('username').value;
            var email = document.getElementById('email').value;
            var password = document.getElementById('password').value;


            var usernameRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$/;
            if (!usernameRegex.test(username)) {
                Swal.fire({
                    title: "Invalid UserName",
                    text: "Username format is incorrect. Please provide a valid Username: Minimum six characters, at least one uppercase letter, one lowercase letter, and one number.",
                    icon: "Failure"
                });
              
                return false;
            }

            var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()])[A-Za-z\d!@#$%^&*()]{8,20}$/;
            if (!passwordRegex.test(password)) {
                alert("Password format is incorrect. Please provide a valid Password: Minimum eight and maximum 20 characters, at least one uppercase letter, one lowercase letter, one number, and one special character: !");
                return false;
            }

            return true;
        }
*/
        const parameters = window.location.search;
        const urlParams = new URLSearchParams(parameters);
        const error = urlParams.get("error");

        if (error === "1") {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Passwords to confirm password do not match!'
            });
        }
    
        document.getElementById("city").addEventListener("change", fetchAreas);

        function fetchAreas() {
            var selectedCity = document.getElementById("city").value;
            console.log("fetchAreas() called")
        //    fetch('/areas?selectedCity=' + selectedCity)
        console.log(selectedCity)
            fetch('/areas/' + selectedCity)
                .then(response => response.json())
                .then(data => {
                        console.log("fjsgh")
                        populateAreas(data)
                    }
                );
        }


        function populateAreas(areas) {
            console.log(areas)
            var areaDropdown = document.getElementById("area");
            areaDropdown.innerHTML = ""; // Clear existing options
            console.log("populateAreas() called");
            console.log(areas.areaId)
            if(areas == null){
                console.log("Areas is null");
            }
            areas.forEach(area => {
                console.log(area)
                var option = document.createElement("option");
                option.text = area.areaName;
                option.value = area.areaName;
                areaDropdown.appendChild(option);
            });
        }


    </script>
</body>
</html>
