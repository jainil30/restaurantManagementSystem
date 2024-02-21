<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="card m-5">
    <div class="card-body">
        <h5 class="card-title">Complaint Details</h5>
        <div class="btn-group" role="group" aria-label="City Actions">
          <button type="button" class="btn btn-dark m-2" id="copyBtn">Copy</button>
          <button type="button" class="btn btn-primary m-2" id="csvBtn">CSV</button>
          <button type="button" class="btn btn-success m-2"  id="excelBtn">Excel</button>
          <button type="button" class="btn btn-danger m-2" id="pdfBtn">PDF</button>
          <button type="button" class="btn m-2" id="printBtn">Print</button>
        </div>
            <table id="viewTable" class="table table-hover">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Subject</th>
                    <th>Description</th>
                    <th>Complaint Date</th>
                    <th>Reply</th>
                    <th></th>
                    <th>Reply Date</th>
                    <th>Attachment</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="complaint" items="${complaints}">
                    <tr>
                        <td>${complaint.complaintId}</td>
                        <td>${complaint.complaintSubject}</td>
                        <td>${complaint.complaintDescription}</td>
                        <td>${complaint.complaintDate}</td>
                        <td>${complaint.complaintReply}</td>
                        <td><a href="/admin/showReply/${complaint.complaintId}" class="bi bi-reply-fill" id="addBtn"></a></td>
                        <td>${complaint.complaintReplyDate}</td>
                        <td><a href="/admin/viewComplaintAttachment/${complaint.complaintAttachmentUrl}" class="bi bi-link-45deg"></a></td>
                        <td>
                            <c:choose>
                                <c:when test="${complaint.complaintStatus eq 'IN_PROGRESS'}">
                                        <span class="badge text-bg-primary p-2">IN PROGRESS</span>
                                </c:when>
                                <c:when test="${complaint.complaintStatus eq 'RESOLVED'}">
                                        <span class="badge text-bg-success p-2">Resolved</span>
                                </c:when>
                                <c:when test="${complaint.complaintStatus eq 'PENDING'}">
                                        <span class="badge text-bg-warning p-2">PENDING</span>
                                </c:when>
                                <c:when test="${complaint.complaintStatus eq 'UNSOLVED'}">
                                        <span class="badge text-bg-danger p-2">UNSOLVED</span>
                                </c:when>
                                <c:otherwise>
                                        <span class="badge text-bg-danger">Unresolved</span>                                    
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>                  
                </c:forEach>
             </tbody>
            <!-- <tbody>
                <tr>
                    <td>1</td>
                    <td>Jainil</td>
                    <td>Regarding Food Quality</td>
                    <td class="descriptionColumn">The dish tasted very bad and quality was also not
                        up to the mark</td>
                    <td>2024-02-16 18:11:00</td>
                    <td>We will definatly take this into account</td>
                    <td>2024-02-17 18:11:00</td>
                    <td><a href="/"><i class="bi bi-link-45deg"></i></a></td>
                    <td>
                        <span class="badge text-bg-success">Resolved</span>
                    </td>
                </tr>
            </tbody> -->
        </table>

    </div>
</div>
