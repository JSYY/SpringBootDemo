package com.example.SpringDemo.JavaTest.Clone;

public class Address implements Cloneable{
    private String name;

    public Address(String name){
        this.name=name;
    }

    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
