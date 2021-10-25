package com.rsrj.coursewebservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrj.coursewebservices.entities.Category;
import com.rsrj.coursewebservices.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id){
		/*Não tem tratamento de erro contra um id invalido ainda*/
		Optional<Category> categoryOptional = categoryRepository.findById(id);
		return categoryOptional.get();
	}
	
}
