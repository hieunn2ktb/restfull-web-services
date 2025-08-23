package com.example.rest.webservices.restfull_web_services.repository;

import com.example.rest.webservices.restfull_web_services.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
