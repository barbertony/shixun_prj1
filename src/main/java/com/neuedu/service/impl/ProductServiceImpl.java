package com.neuedu.service.impl;

import com.neuedu.dao.ProductMapper;
import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public List<Product> selectAll() {
        return productMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Product record) {

        return productMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public List<String> subImages(String subImages) {
        List<String> sunImageslist=new ArrayList<>();
        String str=subImages;
        String[] strArr = str.split("\\,");
        for (String s:strArr
        ) {
            sunImageslist.add(s);
            System.out.println(s);
        }
        return sunImageslist;
    }
}
