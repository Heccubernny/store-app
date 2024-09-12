package com.mama.pride.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mama.pride.entities.Order;
import com.mama.pride.entities.UserProfile;
import com.mama.pride.enums.Status;

public interface OrderDao extends JpaRepository<Order, Integer> {
    List<Order> findByStatus(Status status);

    List<Order> findByStatusNot(Status non_status);

    List<Order> findByStaffId(UserProfile staffId);

    @Query(value = "SELECT staff_id FROM orders WHERE status != 'delivered' GROUP BY status ORDER by COUNT(staff_id) LIMIT 1", nativeQuery = true)
    int getMinStaffId();

}
