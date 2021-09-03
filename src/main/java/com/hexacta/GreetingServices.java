package com.hexacta;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingServices {

    public String greeting(String name) {
        return "hola " + name;
    }

}
