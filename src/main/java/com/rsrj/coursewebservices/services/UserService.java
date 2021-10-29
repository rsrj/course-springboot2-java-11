package com.rsrj.coursewebservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsrj.coursewebservices.entities.User;
import com.rsrj.coursewebservices.repositories.UserRepository;

@Service
/* Component Registration
 * Component
 * Repository
 * Service*/
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id){
		Optional<User> userOptional= repository.findById(id);
		return userOptional.get();
	}
	
	public User insert(User user) {	
		return repository.save(user);
	}
	
	public void delete(Long id) {
//		Optional<User> user = repository.findById(id);
//		repository.delete(user.get());
		repository.deleteById(id);
	}
	
	
}
