package com.example.studentservicemph.VO;

/**
 * @author MPHuy on 28/09/2021
 */

import com.example.studentservicemph.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseTemplateVO {
    private Student student;
    private Department department;
}
