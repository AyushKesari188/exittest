package com.nagarro.ExitTestRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.ExitTestRestApi.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	Users findByEmailAndPassword(String email, String password);
	Users findByEmail(String email);
}
