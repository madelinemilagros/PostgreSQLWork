package com.example.postgresdemo.controller;

import com.example.postgresdemo.exception.ResourceNotFoundException;
import com.example.postgresdemo.model.Test;
import com.example.postgresdemo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/test")
    public Page<Test> getTests(Pageable pageable) {
        return testRepository.findAll(pageable);
    }


    @PostMapping("/test")
    public Test createTest(@Valid @RequestBody Test test) {
        return testRepository.save(test);
    }

    @PutMapping("/test/{testId}")
    public Test updateTest(@PathVariable Long testId,
                                   @Valid @RequestBody Test testRequest) {
        return testRepository.findById(testId)
                .map(test -> {
                    test.setTitle(testRequest.getTitle());
                    test.setDescription(testRequest.getDescription());
                    return testRepository.save(test);
                }).orElseThrow(() -> new ResourceNotFoundException("Test not found with id " + testId));
    }


    @DeleteMapping("/test/{testId}")
    public ResponseEntity<?> deleteTest(@PathVariable Long testId) {
        return testRepository.findById(testId)
                .map(test -> {
                    testRepository.delete(test);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Test not found with id " + testId));
    }
}
