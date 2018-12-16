package com.lzx.entity;

import java.lang.reflect.Field;

public class Demo {

    private String name;

    public void getName(){
        System.out.println(this.name);
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Demo demo = new Demo();

        Field field = demo.getClass().getDeclaredField("name");
        // field.setAccessible(true);
        field.set(demo, "我不知道");

        demo.getName();
    }
}
