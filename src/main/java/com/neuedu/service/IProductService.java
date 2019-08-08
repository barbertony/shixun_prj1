package com.neuedu.service;

import com.neuedu.pojo.Product;

import java.util.List;

public interface IProductService {
    List<Product> selectAll();
    int updateByPrimaryKey(Product record);
    int deleteByPrimaryKey(Integer id);
    int insert(Product record);
    List<String>subImages(String subImages);
}
