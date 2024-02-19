package com.jainil.restaurantManagementSystem.repository;

import com.jainil.restaurantManagementSystem.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
