package com.example.studentservicemph.Controller;

import com.example.studentservicemph.Entity.Student;
import com.example.studentservicemph.Repository.StudentRepository;
import com.example.studentservicemph.Service.StudentService;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MPHuy on 28/09/2021
 */

@RestController
@RequestMapping("/students")
//@EnableEurekaClient
public class StudentController
{
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public Student saveUser(@RequestBody Student student){

        return studentService.saveUser(student);
    }
    @GetMapping("/")
    public List<Student> getALL(){
        return studentRepository.findAll();
    }

}