package com.lzy.java1;

/**
 * @author: lzy
 * @description: 创建商品类
 * @date: 2020-09-12-19:06
 */
public class Goods implements Comparable{
    private String name;
    private int price;

    public Goods() {
    }

    public Goods(String name,int price){
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            Goods goods=(Goods)o;
            if(this.price>goods.price)
                return 1;
            else if(this.price<goods.price)
                return -1;
            else
                return 0;
            //方式2
            //return Double.compare(this.price,goods.price);
        }
        throw  new RuntimeException("传入数据不一致！");

    }
}
