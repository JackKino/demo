package com.example.demo.mybatis.mapper;

import com.example.demo.mybatis.po.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
     List<Product> findProduct(@Param("pname") String pname);
}
