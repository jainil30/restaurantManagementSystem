package com.jainil.restaurantManagementSystem.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@Table(name = "tbl_complaint")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintId;

    private String complaintSubject;
    private String complaintDescription;

    @Temporal(TemporalType.TIMESTAMP)
    private Date complaintDate;
    private String complaintReply;

    @Temporal(TemporalType.TIMESTAMP)
    private Date complaintReplyDate;
    private String complaintAttachmentUrl;

    @Enumerated(EnumType.STRING)
    private ComplaintStatus complaintStatus;

    @PrePersist
    protected void onCreate() {
        complaintDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        complaintReplyDate = new Date();
    }

}
