package com.example.studentservicemph.Service;

import com.example.studentservicemph.Entity.Student;
import com.example.studentservicemph.Repository.StudentRepository;
import com.example.studentservicemph.VO.Department;
import com.example.studentservicemph.VO.ResponseTemplateVO;


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
    @RateLimiter(name = "basicExample")
    @Retry(name="basic",fallbackMethod = "orderFallback")
    public ResponseTemplateVO getUserWithDepartment(Long studentId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Student student = studentRepository.findById(studentId).get();
        //System.out.println(student);
        vo.setStudent(student);
        Department department =
                restTemplate.getForObject("http://localhost:9001/department/"
                                + student.getDepartmentId(),
                        Department.class);
        vo.setDepartment(department);
        return vo;
    }

    public ResponseTemplateVO orderFallback(RuntimeException e) {
        System.out.println("service is down!");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        return vo;
    }
}
