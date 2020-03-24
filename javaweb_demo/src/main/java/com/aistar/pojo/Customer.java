package com.aistar.pojo;

public class Customer {
    private Integer customerId;
    private String customerName;
    private String customerPwd;
    public Customer(){}
    public Customer(Integer customerId, String customerName, String customerPwd) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPwd = customerPwd;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPwd() {
        return customerPwd;
    }

    public void setCustomerPwd(String customerPwd) {
        this.customerPwd = customerPwd;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerPwd='" + customerPwd + '\'' +
                '}';
    }
}
