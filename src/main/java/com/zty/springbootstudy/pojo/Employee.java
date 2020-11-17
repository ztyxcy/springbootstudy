package com.zty.springbootstudy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author admin
 */
@Data
@NoArgsConstructor
public class Employee {
    private Integer eid;
    private String ename;
    private String email;
    private Integer gender;
    private Department department;
    private Date birth;

    public Employee(Integer eid, String ename, String email, Integer gender, Department department) {
        this.eid = eid;
        this.ename = ename;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();
    }
}
