package com.rsrj.coursewebservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrj.coursewebservices.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
