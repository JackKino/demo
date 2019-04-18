package com.example.demo.mybatis.po;

import org.apache.ibatis.type.Alias;

import java.util.List;
import java.util.Set;

@Alias(value = "category")
public class Category {
    private Integer id;
    private String category_name;
    private Set<Product> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
