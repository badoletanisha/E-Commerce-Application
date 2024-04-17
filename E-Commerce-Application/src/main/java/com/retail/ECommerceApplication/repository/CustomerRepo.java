package com.retail.ECommerceApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.ECommerceApplication.entity.User;

public interface CustomerRepo extends JpaRepository<User, Integer>{


}
