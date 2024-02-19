<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="container mt-5">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">Add Complaint</h5>
            <form id="form"  action="/restaurant/registerComplaint" method="POST" enctype="multipart/form-data">
            <div class="mb-3">
            <label for="complaintSubjectInput" class="form-label">Complaint Subject</label>
            <input type="text" class="form-control" id="complaintSubjectInput" name="complaintSubject" required>
        </div>
            <div class="mb-3">
                <label for="complaintDescriptionTextarea" class="form-label">Complaint Description</label>
                <textarea class="form-control" id="complaintDescriptionTextarea" name="complaintDescription" rows="3"  required></textarea>
            </div>
            <div class="mb-3">
                <label for="attachmentInput" class="form-label">Attachment</label>
                <input class="form-control" type="file" name="file" id="attachmentInput"  required>
            </div>
            <button class="btn btn-primary float-end">Save</button>
        </form>
        </div>
    </div>
</div>
