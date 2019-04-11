package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.po.PersonInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PersonInfoMapper {
 @Select("select * from info")
 List<PersonInfo> getInfo2();

 PersonInfo queryInfo(@Param("id") int id, @Param("address")String flower);
}
