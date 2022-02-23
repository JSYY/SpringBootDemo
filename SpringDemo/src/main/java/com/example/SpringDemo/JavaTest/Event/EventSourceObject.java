package com.example.SpringDemo.JavaTest.Event;

import java.util.ArrayList;
import java.util.List;

/*
* java中的事件机制的参与者有3种角色：

1.event object（事件类，事件触发/发布）：事件状态对象，用于listener的相应的方法之中，作为参数，一般存在于listerner的方法之中

2.event source（事件源类）：具体的事件源，比如说，你点击一个button，那么button就是event source，要想使button对某些事件进行响应，你就需要注册特定的listener。

3.event listener（监听类）：对每个明确的事件的发生，都相应地定义一个明确的Java方法。这些方法都集中定义在事件监听者（EventListener）接口中，这个接口要继承 java.util.EventListener。
*                         实现了事件监听者接口中一些或全部方法的类就是事件监听者。
*
* java事件机制的思想有点类似于设计模式中的观察者模式
* */

public class EventSourceObject {
    //监听器容器
    List<BaseListener> listenerList;

    public EventSourceObject(){
        listenerList = new ArrayList<BaseListener>();
    }

    public void RegisterListener(BaseListener baseListener){
        listenerList.add(baseListener);
    }

    public void sendEvent(BaseEvent baseEvent){
        for (BaseListener listener : listenerList) {
            listener.onEvent(baseEvent);
        }
    }

    public static void main(String[] args) {
        //创建事件
        BaseEvent event = new BaseEvent("事件源");

        //事件触发后该对象监听到后 完成其他动作
        EventTest et = new EventTest();

        //事件源 发生的地方
        EventSourceObject esb= new EventSourceObject();
        //添加监听器
        esb.RegisterListener(et);
        //触发事件
        esb.sendEvent(event);
    }
}
