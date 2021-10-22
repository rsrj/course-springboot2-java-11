package com.rsrj.coursewebservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrj.coursewebservices.entities.User;

/*Não é necessario fazer o registro do componente, uma vez que o JpaRepository já faz esse registro*/
public interface UserRepository extends JpaRepository<User, Long>{

}
