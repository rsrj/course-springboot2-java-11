package com.rsrj.coursewebservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrj.coursewebservices.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
