package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
