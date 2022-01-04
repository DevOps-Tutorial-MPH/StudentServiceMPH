package com.example.studentservicemph.Service;

import com.example.studentservicemph.Entity.Student;
import com.example.studentservicemph.Repository.StudentRepository;



import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author MPHuy on 28/09/2021
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Student saveUser(Student student) {
        return studentRepository.save(student);
    }
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

}
