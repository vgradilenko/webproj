package com.andersen.model;

import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
@Controller
public class HelloWorld {

    public HelloWorld(){
        System.out.println("HelloWorld started");
    }

    public String getMessage(){
        return "Hello World";
    }
}
