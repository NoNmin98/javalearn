package com.lzy.enumlearn;

import org.junit.Test;

/**
 * @author: lzy
 * @description: enum
 * @date: 2020-09-14-11:35
 */
public class EnumTest {
    @Test
    public void test1(){

    }
}

class Week{
    private final String wekName;

    Week(String wekName) {
        this.wekName = wekName;
    }
}

enum Season1 {
    SPRING("SPRING","GOOD"),
    SUMMER("summer","very good")
    ;

    Season1(String spring, String good) {

    }
}