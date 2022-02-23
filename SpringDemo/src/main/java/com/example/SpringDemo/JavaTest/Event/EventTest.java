package com.example.SpringDemo.JavaTest.Event;

public class EventTest implements BaseListener{
    @Override
    public void onEvent(BaseEvent event) {
        System.out.println(event.getSource());
        Method();
    }

    public void Method(){
        System.out.println("receive event and do other thing");
    }

}
