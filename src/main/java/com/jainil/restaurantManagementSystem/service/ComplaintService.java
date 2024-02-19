package com.jainil.restaurantManagementSystem.service;

import com.jainil.restaurantManagementSystem.entity.Complaint;

import java.util.List;

public interface ComplaintService {
    List<Complaint> fetchAllComplaints();

    void saveComplaint(Complaint complaint);
}
