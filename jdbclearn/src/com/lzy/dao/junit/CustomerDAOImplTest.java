package com.lzy.dao.junit;

import com.lzy.JDBCUtils.JDBCUtils;
import com.lzy.bean.Customer;
import com.lzy.dao.CustomerDAOImpl;

import java.sql.Connection;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: lzy
 * @description:
 * @date: 2020-10-13-20:24
 */
class CustomerDAOImplTest {

    CustomerDAOImpl dao=new CustomerDAOImpl();
    //使用try-catch
    @org.junit.jupiter.api.Test
    void insert() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        Customer cust = new Customer(1,"nihao","xiaofei@qq.com",new Date(23840293480L));
        dao.insert(conn,cust);
        JDBCUtils.closeResource(conn,null);
    }

    @org.junit.jupiter.api.Test
    void deleteById() {
    }

    @org.junit.jupiter.api.Test
    void update() {
    }

    @org.junit.jupiter.api.Test
    void getCustomerById() {
    }

    @org.junit.jupiter.api.Test
    void getAll() {
    }

    @org.junit.jupiter.api.Test
    void getCount() throws Exception {
        Connection conn = JDBCUtils.getConnection();

        Long count = dao.getCount(conn);
        System.out.println(count);

        JDBCUtils.closeResource(conn,null);
    }
}