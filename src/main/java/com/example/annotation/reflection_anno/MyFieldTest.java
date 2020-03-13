package com.example.annotation.reflection_anno;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class MyFieldTest {
    @MyField(description = "用户名", length = 12)
    private String username;

    @Test
    public void testMyField() {
        //获取类模板
        Class<MyFieldTest> aClass = MyFieldTest.class;

        //获取所以字段
        for (Field field : aClass.getDeclaredFields()) {
            //判断这个字段是否有 MyField 注解
            if (field.isAnnotationPresent(MyField.class)) {
                MyField fieldAnnotation = field.getAnnotation(MyField.class);
                System.out.println(String.format("字段：[%S]；描述：[%S]；长度：[%S]",
                        field.getName(),
                        fieldAnnotation.description(),
                        fieldAnnotation.length()));
            }

        }
    }
}
