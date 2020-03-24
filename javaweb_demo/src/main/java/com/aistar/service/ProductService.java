package com.aistar.service;

import com.aistar.pojo.Product;
import com.github.pagehelper.Page;

public interface ProductService extends BaseService<Product>{
    public boolean delete(String id);
    public Product getById(String id);
    public Page<Product> getAllByPage(Integer pageNum);
}
