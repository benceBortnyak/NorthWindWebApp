package com.codecool.web.model;

import java.util.List;

public class Task4 {

    private String company;
    private List<Short> orderId;

    public Task4(String company, List<Short> orderId) {
        this.company = company;
        this.orderId = orderId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Short> getOrderId() {
        return orderId;
    }

    public void setOrderId(List<Short> orderId) {
        this.orderId = orderId;
    }
}
