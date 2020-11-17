package com.zty.springbootstudy.dao;

import com.zty.springbootstudy.pojo.Department;
import com.zty.springbootstudy.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    private static Integer initid = 1006;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();
        employees.put(1001,new Employee(1001,"Alice","zty1@qq.com",0,new Department(101,"事业一")));
        employees.put(1002,new Employee(1002,"Bob","zty2@qq.com",1,new Department(102,"事业二")));
        employees.put(1003,new Employee(1003,"Cue","zty3@qq.com",0,new Department(103,"事业三")));
        employees.put(1004,new Employee(1004,"Dav","zty4@qq.com",1,new Department(104,"事业四")));
        employees.put(1005,new Employee(1005,"Elu","zty5@qq.com",0,new Department(105,"事业五")));
    }

    public Collection<Employee> getEmployees(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void add(Employee e){
        if (e.getEid() == null){
            e.setEid(initid++);
        }
        e.setDepartment(departmentDao.getDepartmentsById(e.getDepartment().getId()));
        employees.put(e.getEid(),e);
    }

    public void deleteEmployee(Integer id){
        employees.remove(id);
    }
}
