package com.hexacta;

import com.hexacta.dao.GreetingDAO;
import com.hexacta.model.Greeting;

import javax.transaction.Transactional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GreetingServices {

    @Inject
    private GreetingDAO dao;

    public String greeting(String name) {
        return "hola " + name;
    }

    public String greeting(int id,String name) {
        Greeting aGreeting = dao.get(id);
        if (aGreeting == null) {
            return name;
        }
        return aGreeting.getValue() + " " + name;
    }

    @Transactional
    public int saveGreeting(String greeting) {
        Greeting aGreeting = new Greeting(greeting);
        return dao.save(aGreeting);
    }
}
