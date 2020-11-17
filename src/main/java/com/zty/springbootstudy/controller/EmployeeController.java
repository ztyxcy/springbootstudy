package com.zty.springbootstudy.controller;

import com.zty.springbootstudy.dao.DepartmentDao;
import com.zty.springbootstudy.dao.EmployeeDao;
import com.zty.springbootstudy.pojo.Department;
import com.zty.springbootstudy.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author admin
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //从dashboard.html员工管理进入
    @RequestMapping("/emplist")
    public String empList(Model model){
        Collection<Employee> employees = employeeDao.getEmployees();
        model.addAttribute("temps",employees);
        return "emps/list";
    }

    //添加员工按钮，get请求
    @GetMapping("/emp/add")
    public String toAdd(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emps/add";
    }

    //重新跳转到员工管理页面，post请求
    @PostMapping("/emp/add")
    public String empAdd(Employee emp){
        System.out.println(emp);
        employeeDao.add(emp);
        return "redirect:/emplist";
    }

    @GetMapping("/emp/update/{eid}")
    public String toUpdate(@PathVariable("eid") Integer eid,Model model){
        Employee employee = employeeDao.getEmployeeById(eid);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emps/update";
    }

    @PostMapping("/updateEmp")
    public String empUpdate(Employee emp){
        employeeDao.add(emp);
        return "redirect:/emplist";
    }

    @GetMapping("/emp/delete/{id}")
    public String empDelete(@PathVariable("id")Integer id){
        employeeDao.deleteEmployee(id);
        return "redirect:/emplist";
    }
}
