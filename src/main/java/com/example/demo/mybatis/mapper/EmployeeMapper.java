package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.po.Employee;
import com.example.demo.mybatis.po.EmployeeTask;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    Employee getEmployeeByEmpId(@Param("empId") Integer empId);

}
