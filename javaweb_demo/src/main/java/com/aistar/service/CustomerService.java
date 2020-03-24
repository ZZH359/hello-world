package com.aistar.service;

import com.aistar.pojo.Customer;

public interface CustomerService extends BaseService<Customer> {
    public Customer getByUsernameAndPwd(String username ,String password);
}
