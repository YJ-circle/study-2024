package com.spring.springorm.mybatis.mybatispractice.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public class Member {
    private String id;
    private String password;
    private String name;
    private String address;

    public String getId() {
        return id;
    }

    public Member setId(String id) {
        this.id = id;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Member setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Member setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "\nid: " + id + "\n" +
                "password='" + password + "\n" +
                "name='" + name + "\n" +
                "address='" + address;
    }
}