package com.example.SpringDemo.Service;

import com.example.SpringDemo.Dao.PersonMapper;
import com.example.SpringDemo.JavaBean.Person;
import com.example.SpringDemo.JavaBean.PersonOuterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//标记为service
@Service
public class TestService {

    //对后端接口进行测试
    @Autowired
    PersonMapper personMapper;

    public List<Person> getPersonList(){
        List<Person> res = personMapper.getAllPerson();
        return res;
    }
    public int addPerson() {
        Person p = new Person("555","jerry");
        return personMapper.addPerson(p);
    }

    public void deletePerson(){
        List<String> list = new ArrayList<String>();
        list.add("555");
        personMapper.deletePerson(list);
    }

    public void UpdatePerson(){
        Person p = new Person("234","ljw123");
        personMapper.updatePersonInfo(p);
    }

}
