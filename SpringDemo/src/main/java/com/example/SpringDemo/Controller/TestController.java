package com.example.SpringDemo.Controller;

import com.example.SpringDemo.JavaBean.Person;
import com.example.SpringDemo.JavaBean.PersonOuterClass;
import com.example.SpringDemo.Service.TestService;
import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Base64;
import java.util.List;

//标记为controller
@RestController
public class TestController {
    //依赖注入
    @Autowired
    TestService testService;

    @RequestMapping(value = "/start",produces = "text/plain;charset=UTF-8")
    public String start(){
        return "Hello Spring";
    }

    //Url中的参数
    @RequestMapping(value = "/sendIdAndName/{id}",produces = "text/plain;charset=UTF-8")
    public void sendIdAndName(@PathVariable(value = "id") String id,@RequestParam(name="name")String name) throws InterruptedException {
        System.out.println("sendIdAndNameApi:"+id);
        System.out.println("sendIdAndNameApi:"+name);
        Thread.sleep(1000);
    }

    //接收Json数据返回一个Json对象
    @ResponseBody
    @RequestMapping(value = "/sendJsonData")
    public Object sendJsonData(@RequestBody Person person){
        System.out.println("sendJsonDataApi:"+person.getId());
        System.out.println("sendJsonDataApi:"+person.getName());
        Person np = new Person("321","json");
        return np;
    }

    //拿到前端post请求中的protobuf反序列化并返回一个protobuf
    @RequestMapping(value="/getPostRequest")
    public byte[] getPostRequest(String data,String type) throws InvalidProtocolBufferException {
        System.out.println(data);
        System.out.println(type);
        byte[] s = Base64.getDecoder().decode(data);
        PersonOuterClass.Person re = PersonOuterClass.Person.parser().parseFrom(s);
        System.out.println("getProtobufApi:"+re.getId());
        System.out.println("getProtobufApi:"+re.getName());

        //protobuf提供的方法toByteArray并没有真正的转成我们想要的byte[],因此需要将这个ByteArray用Base64工具类再转化一遍
        byte[] res = Base64.getEncoder().encode(re.toByteArray());
        return  res;
    }
    //获取person的列表并以一个json对象返回
    @ResponseBody
    @RequestMapping(value = "/getPersonList")
    public Object getPersonList(){
        List<Person> data = testService.getPersonList();
        return data;
    }
}
