package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.po.FeMaleHealthForm;
import com.example.demo.mybatis.po.MaleHealthForm;
import org.apache.ibatis.annotations.Param;

public interface FeMaleHealthFormMapper {
    FeMaleHealthForm getFeMale(@Param("id") long id);
}
