package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.po.EmployeeTask;
import org.apache.ibatis.annotations.Param;

public interface EmployeeTaskMapper {
    EmployeeTask getEmployeeTaskByEmpId(@Param("empId") Integer empId);

}
