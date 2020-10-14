package com.lzy.dao1;

import com.lzy.bean.Customer;

import java.sql.Connection;
import java.util.List;

/**
 * @author: lzy
 * @description: 此接口用于规范针对customers的通用操作
 * @date: 2020-10-13-19:28
 */
public interface CustomerDAO {

    void insert(Connection conn, Customer cust);
    void deleteById(Connection conn, int id);
    //void updateById(Connection conn,Customer cust);
    void update(Connection conn, Customer cust);
    Customer getCustomerById(Connection conn, int id);
    List<Customer> getAll(Connection conn);
    Long getCount(Connection conn);
}
