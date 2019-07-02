package com.codecool.web.service;

import com.codecool.web.model.*;

import java.util.ArrayList;
import java.util.List;

public class TaskFilterService {

    public List<Task1> Task1Filter(List<Task1> task1List, String product, String company) {
        List<Task1> returnList = new ArrayList<>();

        if (product.equals("") && company.equals("")) {
            return task1List;
        }
        if (product.equals("")) {
            for (int i = 0; i < task1List.size(); i++) {
                if (task1List.get(i).getCompany().equals(company)) {
                    returnList.add(task1List.get(i));

                }
            }
            return returnList;
        } else if (company.equals("")) {
            for (int i = 0; i < task1List.size(); i++) {
                if (task1List.get(i).getProduct().equals(product)) {
                    returnList.add(task1List.get(i));
                }
            }
            return returnList;

        }
        return null;
    }

    public List<Task2> Task2Filter(List<Task2> task2List, String product, Integer products) {
        List<Task2> returnList = new ArrayList<>();

        if (product.equals("") && products.equals(0)) {
            return task2List;
        }
        if (product.equals("")) {
            for (int i = 0; i < task2List.size(); i++) {
                if (task2List.get(i).getProducts().equals(products)) {
                    returnList.add(task2List.get(i));

                }
            }
            return returnList;
        } else if (products == 0) {
            for (int i = 0; i < task2List.size(); i++) {
                if (task2List.get(i).getProduct().equals(product)) {
                    returnList.add(task2List.get(i));
                }
            }
            return returnList;

        }
        return null;
    }

    public List<Task3> Task3Filter(List<Task3> task2List, String company) {
        List<Task3> returnList = new ArrayList<>();

        for (int i = 0; i < task2List.size(); i++) {
            if (task2List.get(i).getCompany().equals(company)) {
                returnList.add(task2List.get(i));
            }
        }
        if (returnList.size() == 0) {
            return task2List;
        } else {
            return returnList;
        }
    }

    public List<Task4> task4Filter(List<Task4> task4List, Short agg, String company) {
        List<Task4> returnList = new ArrayList<>();
        if (agg == 0 && company.equals("")) {
            return task4List;
        }
        if (agg != 0) {
            for (int i = 0; i < task4List.size(); i++) {
                for (int j = 0; j < task4List.get(i).getOrderId().size(); j++) {
                    if (agg.equals(task4List.get(i).getOrderId().get(j))) {
                        returnList.add(task4List.get(i));
                    }
                }
            }
            return returnList;
        } else if (!company.equals("")) {
            for (int i = 0; i < task4List.size(); i++) {
                if (task4List.get(i).getCompany().equals(company)) {
                    returnList.add(task4List.get(i));
                }
            }
            return returnList;
        }
        return null;
    }

    public List<Task5> task5Filter(List<Task5> task5List, String company, String product, Float price) {
        List<Task5> returnList = new ArrayList<>();
        if (company.equals("") && product.equals("") && Math.round(price) == 0) {
            return task5List;
        }
        if (!company.equals("")) {
            for (int i = 0; i < task5List.size(); i++) {
                if (task5List.get(i).getCompany().equals(company)) {
                    returnList.add(task5List.get(i));
                }
            }
            return returnList;
        } else if (!product.equals("")) {
            for (int i = 0; i < task5List.size(); i++) {
                if (task5List.get(i).getProduct().equals(product)) {
                    returnList.add(task5List.get(i));
                }
            }
            return returnList;
        } else if (price != 0) {
            for (int i = 0; i < task5List.size(); i++) {
                if (Math.round(task5List.get(i).getPrice()) == Math.round(price)) {
                    returnList.add(task5List.get(i));
                }
            }
            return returnList;
        }
        return null;
    }
}
