package com.example.demo.mybatis.po;

import org.apache.ibatis.type.Alias;

@Alias(value = "product")
public class Product {
    private Integer p_id;
    private Integer c_id;
    private String name;
    private Double price;

    public Integer getId() {
        return c_id;
    }

    public void setId(Integer c_id) {
        this.c_id = c_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }
}
