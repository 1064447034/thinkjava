package com.ly.study.thinkjava.encrypt;

import java.util.UUID;

class Parent{    
    static String a = "hello";    
    
    {    
    	System.out.println("name1 " + name);
        System.out.println("3 parent  block");    
    }    
    
    public Parent(){    
    	System.out.println("name2 " + name);
        System.out.println("4 parent constructor");    
    } 
    static int name = new Integer(3);
    static {    
    	System.out.println("name0 " + name);
        System.out.println("1 parent static block");    
    }    
}    
    
class Child extends Parent{    
    static String childName = "hello";    
    
    {    
        System.out.println("5 child  block");    
    }    
    static {    
        System.out.println("2 child static block");    
    }  
    
    public Child(){    
        System.out.println("6 child constructor");    
    }    
} 
    
public class Test {
    public static void main(String[] args) {    
    	System.out.println( UUID.randomUUID().toString());
        new Child();//语句(*)    
    }    
}
