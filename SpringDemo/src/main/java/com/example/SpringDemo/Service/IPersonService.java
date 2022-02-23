package com.example.SpringDemo.Service;

import com.example.SpringDemo.JavaBean.Person;

import java.util.List;

public interface IPersonService {
    List<Person>  getPersonList();

    int updatePersonInfo(Person person);

    int addPerson(Person person);

    int deletePerson(String id);
}
