package com.rsrj.coursewebservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrj.coursewebservices.entities.OrderItem;

/*Não é necessario fazer o registro do componente, uma vez que o JpaRepository já faz esse registro*/
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
