package com.jainil.restaurantManagementSystem.service;


import com.jainil.restaurantManagementSystem.entity.Complaint;
import com.jainil.restaurantManagementSystem.entity.ComplaintStatus;
import com.jainil.restaurantManagementSystem.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImplementation implements ComplaintService{

    @Autowired
    private ComplaintRepository complaintRepository;

    @Override
    public List<Complaint> fetchAllComplaints() {
        return this.complaintRepository.findAll();
    }

    @Override
    public void saveComplaint(Complaint complaint) {
        complaint.setComplaintStatus(ComplaintStatus.PENDING);

        System.out.println(complaint.toString());
        this.complaintRepository.save(complaint);
    }

    @Override
    public Complaint fetchComplaintById(Long id) {
        return this.complaintRepository.findById(id).get();
    }

    @Override
    public void updateComplaint(Complaint complaint) {
        this.complaintRepository.save(complaint);
    }
}
