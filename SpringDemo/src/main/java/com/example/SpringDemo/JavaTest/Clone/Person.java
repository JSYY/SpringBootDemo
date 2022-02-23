package com.example.SpringDemo.JavaTest.Clone;

public class Person implements Cloneable{
    private Address address;

    public Person(Address address){
        this.address=address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    //浅拷贝
    public Person clone() {
        try {
            Person person = (Person) super.clone();
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public Person DeepClone(){
        try {
            Person person = (Person) super.clone();
            person.setAddress(person.getAddress().clone());
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /*
    * 浅拷贝：浅拷贝会在堆上创建一个新的对象（区别于引用拷贝的一点），不过，如果原对象内部的属性是引用类型的话，浅拷贝会直接复制内部对象的引用地址，也就是说拷贝对象和原对象共用同一个内部对象。
      深拷贝 ：深拷贝会完全复制整个对象，包括这个对象所包含的内部对象。
    * */
    public static void main(String[] args) {
        Person person1 = new Person(new Address("wuhan"));
        Person person2 =  person1.clone();
        System.out.println(person1.getAddress() == person2.getAddress());

        Person person3 = person1.DeepClone();
        System.out.println(person1.getAddress() == person3.getAddress());

    }
}
