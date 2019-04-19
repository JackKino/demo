package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.po.MaleHealthForm;
import com.example.demo.mybatis.po.Task;
import org.apache.ibatis.annotations.Param;

public interface MaleHealthFormMapper {
    MaleHealthForm getMale(@Param("id") long id);
}
