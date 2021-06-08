package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.User;
import it.uniroma3.siw.spring.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository; 
	
	@Transactional
	public User salvaUser(User user) {
		return userRepository.save(user);
	}
	
	@Transactional
	public Optional<User> getUser(Long id) {
		return userRepository.findById(id);
	}
} 
