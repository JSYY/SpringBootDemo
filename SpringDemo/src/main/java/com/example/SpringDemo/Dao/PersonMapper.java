package com.example.SpringDemo.Dao;

import com.example.SpringDemo.JavaBean.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersonMapper {
    //查询所有person
    List<Person> getAllPerson();

    //更新人物信息
    int updatePersonInfo(Person person);

    //添加人物信息
    int addPerson(Person person);

    //删除人物信息
    int deletePerson(List<String> ids);
}
