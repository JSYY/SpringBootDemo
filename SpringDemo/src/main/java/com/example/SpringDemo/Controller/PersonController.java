package com.example.SpringDemo.Controller;

import com.example.SpringDemo.JavaBean.Person;
import com.example.SpringDemo.Service.PersonService;
import com.example.SpringDemo.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/TestApi")
public class PersonController {

    @Autowired
    PersonService personService;

    public PersonController(){
        System.out.println("PersonController Init");
    }

    @ResponseBody
    @RequestMapping(value = "/personList")
    public Object getPersonList(){
        List<Person> data = personService.getPersonList();
        return data;
    }

    @RequestMapping(value = "/addPerson")
    public int addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    //删除时前端发送一个id
    @RequestMapping(value = "/deletePerson")
    public int deletePerson(@RequestBody Person person){
        int res = personService.deletePerson(person.id);
        return res;
    }
    @RequestMapping(value = "/updatePerson")
    public int updatePerson(@RequestBody Person person){
        return personService.updatePersonInfo(person);
    }

}
