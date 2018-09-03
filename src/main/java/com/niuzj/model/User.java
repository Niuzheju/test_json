package com.niuzj.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Date;

public class User {
    private String username;

    private Integer age;

    private Date birthday;

    private BigDecimal money;

    public User() {
    }

    public User(String username, Integer age, Date birthday, BigDecimal money) {
        this.username = username;
        this.age = age;
        this.birthday = birthday;
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public static User getDefault() {
        BigDecimal money = new BigDecimal(Math.random() * 10);
        money = money.setScale(2, RoundingMode.HALF_UP);
        return new User("niuzj", 23, new Date(), money);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", money=" + money +
                '}';
    }
}
