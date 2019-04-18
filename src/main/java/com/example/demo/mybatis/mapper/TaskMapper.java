package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.po.Task;
import org.apache.ibatis.annotations.Param;

public interface TaskMapper {
    Task getTask(@Param("pid") long id);
}
