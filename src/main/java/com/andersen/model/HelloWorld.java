package com.andersen.model;

import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "helloWorld", eager = true)
@SessionScoped
@Component
public class HelloWorld implements Serializable {

    public HelloWorld(){
        System.out.println("HelloWorld started");
    }

    public String getMessage(){
        return "Hello, Vova!!!";
    }

    public String hello = "Hello";
}
