package com.aistar.service;

import com.aistar.pojo.Product;
import com.aistar.util.ServerResponse;

public interface ProductAjaxService {
    public ServerResponse add(Product product);
    public  ServerResponse update(Product product);
    public  ServerResponse delete(String proId);
    public  ServerResponse getById(String proId);
    public  ServerResponse getAll();
    public  ServerResponse getAllByPage(Integer pageNum);
}
