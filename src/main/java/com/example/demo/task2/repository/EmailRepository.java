package com.example.demo.task2.repository;

import com.example.demo.task2.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Integer> {
}
