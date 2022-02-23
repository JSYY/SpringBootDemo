package com.example.SpringDemo.JavaTest.Event;

import java.util.EventObject;

public class BaseEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    private Object source;

    public BaseEvent(Object source) {
        super(source);
        this.source=source;
    }

    @Override
    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }
}
