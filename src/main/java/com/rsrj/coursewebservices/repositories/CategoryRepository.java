package com.rsrj.coursewebservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrj.coursewebservices.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
