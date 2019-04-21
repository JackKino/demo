package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.po.EmployeeTask;
import com.example.demo.mybatis.po.WorkCard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkCardMapper {
    WorkCard getWorkCard(@Param("id") long empId);

    List<WorkCard> getWorkCardByNameOrMobile(WorkCard workCard);

    Integer updateWorkCardById(WorkCard workCard);

    List<WorkCard> getWorkCarByForEach(List<Long> workCards);
}
