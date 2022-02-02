package com.techacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techacademy.entity.Authentication;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, String> {
}
