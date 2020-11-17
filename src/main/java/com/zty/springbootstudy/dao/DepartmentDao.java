package com.zty.springbootstudy.dao;

import com.zty.springbootstudy.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
@Repository
public class DepartmentDao {
    private static Map<Integer,Department> departments = null;
    static {
        departments = new HashMap<>();
        departments.put(101,new Department(101,"事业一"));
        departments.put(102,new Department(102,"事业二"));
        departments.put(103,new Department(103,"事业三"));
        departments.put(104,new Department(104,"事业四"));
        departments.put(105,new Department(105,"事业五"));
    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getDepartmentsById(Integer id){
        return departments.get(id);
    }
}
