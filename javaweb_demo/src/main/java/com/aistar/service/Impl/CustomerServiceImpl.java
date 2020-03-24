package com.aistar.service.Impl;

import com.aistar.pojo.Customer;
import com.aistar.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public boolean add(Customer customer) {
        return false;
    }

    @Override
    public boolean modify(Customer customer) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Customer getById(Integer id) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Customer getByUsernameAndPwd(String username, String password) {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1001,"zhangzhonghao","123456"));
        customerList.add(new Customer(1002,"chenzhifeng","123456"));
        customerList.add(new Customer(1003,"xuhengbo","123456"));
        customerList.add(new Customer(1004,"dikaichi","123456"));
        for (Customer customer:customerList){
            if (customer.getCustomerName().equals(username)&&customer.getCustomerPwd().equals(password)){
                return customer;
            }
        }
        return null;
    }
}
