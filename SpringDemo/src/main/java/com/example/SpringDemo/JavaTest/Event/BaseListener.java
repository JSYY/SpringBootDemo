package com.example.SpringDemo.JavaTest.Event;

import java.util.EventListener;

public interface BaseListener extends EventListener {
    void onEvent(BaseEvent event);
}
