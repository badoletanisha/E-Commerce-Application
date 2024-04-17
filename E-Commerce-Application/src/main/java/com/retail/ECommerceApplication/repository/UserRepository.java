package com.retail.ECommerceApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.ECommerceApplication.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	boolean existsByEmail(String email);

}
