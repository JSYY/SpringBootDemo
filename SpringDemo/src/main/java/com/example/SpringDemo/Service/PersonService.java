package com.example.SpringDemo.Service;

import com.example.SpringDemo.Dao.PersonMapper;
import com.example.SpringDemo.JavaBean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements IPersonService{

    @Autowired
    PersonMapper personMapper;

    public PersonService(){
        System.out.println("PersonService Init");
    }

    @Override
    public List<Person> getPersonList() {
        return personMapper.getAllPerson();
    }

    @Override
    public int updatePersonInfo(Person person) {
        return personMapper.updatePersonInfo(person);
    }

    @Override
    public int addPerson(Person person) {
        return personMapper.addPerson(person);
    }

    @Override
    public int deletePerson(String id) {
        List<String> list = new ArrayList<String>();
        list.add(id);
        int res = personMapper.deletePerson(list);
        return 1;
    }
}
