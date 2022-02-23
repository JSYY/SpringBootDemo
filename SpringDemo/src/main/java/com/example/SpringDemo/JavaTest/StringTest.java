package com.example.SpringDemo.JavaTest;

import com.example.SpringDemo.JavaBean.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StringTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(10);
        sb.append("str");
        //和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。
        //而StringBuilder是线程不安全的，但是性能要由于StringBuffer，
        //StringBuffer线程安全，通常单线程下优先使用StringBuilder

        //String equals是重写过的，比较的是字符串的值
        //Object equals是直接比较的对象的内存地址
        String a = "a";
        String b = "a";
        System.out.println(a.equals(b));
        Object o1 = "a";
        Object o2 ="b";
        System.out.println(o1.equals(o2));

        Set s = new HashSet();
        s.add("ljw");
        s.add("aaa");
        System.out.println(s.contains("ljw"));
        //数组其实是一个简单hash表，如果配上hash函数，将key值转化为具体的下标值，则就成了完全的hash表
        //hash表的查找和插入都很快

        Person p1 = new Person("11","ee");
        Person p2 = new Person("11","ee");
        System.out.println(p1==p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

//        如果两个对象的hashCode 值相等，那这两个对象不一定相等（哈希碰撞）。
//        如果两个对象的hashCode 值相等并且equals()方法返回 true，我们才认为这两个对象相等。
//        如果两个对象的hashCode 值不相等，我们就可以直接认为这两个对象不相等。
//        重写equals方法时也要重写hashcode方法
    }

}
