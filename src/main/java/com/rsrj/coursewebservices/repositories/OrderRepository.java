package com.rsrj.coursewebservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrj.coursewebservices.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
