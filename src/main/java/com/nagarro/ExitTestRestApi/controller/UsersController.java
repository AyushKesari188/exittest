package com.nagarro.ExitTestRestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ExitTestRestApi.model.Users;
import com.nagarro.ExitTestRestApi.repository.UsersRepository;

@RestController
@CrossOrigin
public class UsersController {

	@Autowired
	UsersRepository usersRepository;

	@PostMapping(path = "/users", consumes = { "application/json" })
	public ResponseEntity<Object> addUsers(@RequestBody Users user) {
		try {
			usersRepository.save(user);
		} catch (Exception e) {
			return ResponseEntity.ok().body("{\"message\":\"error\"}");
		}
		return ResponseEntity.ok().body("{\"message\":\"success\"}");
	}

	@GetMapping("users")
	public List<Users> getUsers() {
		return usersRepository.findAll();
	}

	@GetMapping("/users/{email}/{password}")
	public ResponseEntity<Object> getLogin(@PathVariable("email") String email,
	                                       @PathVariable("password") String password) {
	    Users user = usersRepository.findByEmail(email);
	    if (user != null && user.getPassword().equals(password)) {
	        return ResponseEntity.ok().body("{\"message\":\"success\"}");
	    } else {
	        return ResponseEntity.ok().body("{\"message\":\"error\"}");
	    }
	}
}
