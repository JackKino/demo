package com.example.demo.mybatis.po;

import org.apache.ibatis.type.Alias;

import java.util.List;
@Alias(value = "category")
public class Category {
    private Integer id;
    private String category_name;
    private List<Product> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return category_name;
    }

    public void setName(String category_name) {
        this.category_name = category_name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
