package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.po.EmployeeTask;
import com.example.demo.mybatis.po.WorkCard;
import org.apache.ibatis.annotations.Param;

public interface WorkCardMapper {
    WorkCard getWorkCard(@Param("id") long empId);

}
