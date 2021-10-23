package com.example.studentservicemph.Repository;

import com.example.studentservicemph.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author MPHuy on 28/09/2021
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
