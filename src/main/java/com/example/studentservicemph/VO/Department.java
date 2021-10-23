package com.example.studentservicemph.VO;

/**
 * @author MPHuy on 28/09/2021
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private long Id;
    private String deparmentName;
    private String deparmentAddress;
    private String deparmentCode;
}

