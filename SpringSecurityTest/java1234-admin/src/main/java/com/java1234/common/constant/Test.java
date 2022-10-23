package com.java1234.common.constant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;


public class Test {
    public static void main(String[] args) {
        Set<Object> set = new HashSet<Object>();
        boolean b1 = set.add("Hello");
        boolean b2 = set.add("Hello");
        boolean b3 = set.add(2018);
        System.out.println(b1);//true
        System.out.println(b2);//true
        System.out.println(b3);//false
    }

}