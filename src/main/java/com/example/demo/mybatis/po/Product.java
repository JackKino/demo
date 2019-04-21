package com.example.demo.mybatis.po;

import org.apache.ibatis.type.Alias;

@Alias(value = "product")
public class Product {
    private Integer id;
    private String name;
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "product:[id="+getId()+"   name="+getName()+"   price="+price;
    }
}
