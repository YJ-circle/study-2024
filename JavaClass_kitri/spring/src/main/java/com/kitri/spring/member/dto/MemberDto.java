package com.kitri.spring.member.dto;

public class MemberDto {
    private String id;
    private String name;
    private String address;

    public String getId() {
        return id;
    }

    public MemberDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MemberDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public MemberDto setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "\nid: " + id + "\n" +
                "name='" + name + "\n" +
                "address='" + address;
    }
}
