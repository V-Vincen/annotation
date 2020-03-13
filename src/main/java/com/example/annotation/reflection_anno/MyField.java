package com.example.annotation.reflection_anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 保留到运行时，可通过注解获取
@Target(ElementType.FIELD)          //  注解用于字段属性上
public @interface MyField {
    String description();

    int length();
}
