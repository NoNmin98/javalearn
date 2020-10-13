package com.lzy.dao;

import com.lzy.bean.Customer;

import java.sql.Connection;
import java.util.List;

/**
 * @author: lzy
 * @description:
 * @date: 2020-10-13-19:34
 */
public class CustomerDAOImpl extends baseDAO implements CustomerDAO{
    @Override
    public void insert(Connection conn, Customer cust) {
        String sql="insert into customers(name,email,birth)values(?,?,?)";
        update(conn,sql,cust.getName(),cust.getEmail(),cust.getDate());
    }

    @Override
    public void deleteById(Connection conn, int id) {

        String sql="delete from customers where id=?";
        update(conn,sql,id);
    }

    @Override
    public void update(Connection conn,Customer cust) {
        String sql="update customers set name=?,email=?,birth=? where id=?";
        update(conn,sql,cust.getName(),cust.getEmail(),cust.getDate(),cust.getId());
    }

    @Override
    public Customer getCustomerById(Connection conn, int id) {
        String sql ="select id ,name,email,birth from customers where id=?";
        Customer instance = null;
        try {
            instance = getInstance(conn, Customer.class, sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    @Override
    public List<Customer> getAll(Connection conn) {
        String sql="select id,name,email,birth from customers";
        List<Customer> forList=null;
        try {
            forList = getForList(conn, Customer.class, sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return forList;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql="select count(*) from customers";
        long value = getValue(conn, sql);
        return value;
    }
}
