<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card m-5">
    <div class="card-body">
        <h5 class="card-title">User Details</h5>

        <table id="userTable" class="table table-light">
            <thead>
                <tr>
                    <th>Email </th>
                    <th>User Name</th>
                    <th>Role</th>
                    <th>Phone No.</th>
                </tr>
            </thead>
                <tbody>
                        <tr>
                            <td>${user.restaurantEmail}</td>
                            <td>${user.restaurantName}</td>
                            <td>${user.role}</td>
                            <td>${user.restaurantContactNo}</td>
                        </tr>           
                 </tbody>
            </tbody>
        </table>
    </div>
</div>
