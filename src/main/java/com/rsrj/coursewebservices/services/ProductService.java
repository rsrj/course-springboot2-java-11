package com.rsrj.coursewebservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrj.coursewebservices.entities.Product;
import com.rsrj.coursewebservices.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository ProductRepository;
	
	public List<Product> findAll(){
		return ProductRepository.findAll();
	}
	
	public Product findById(Long id){
		/*Não tem tratamento de erro contra um id invalido ainda*/
		Optional<Product> obj = ProductRepository.findById(id);
		return obj.get();
	}
	
}
