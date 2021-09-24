package com.hexacta.dao;

import com.hexacta.model.Greeting;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class GreetingDAO {

    @Inject
    private EntityManager em;

    public int save(Greeting aGreeting) {
        this.em.persist(aGreeting);
        return aGreeting.getId();
    }

    public Greeting get(int id) {
        var qr = em.createQuery("from com.hexacta.model.Greeting g where g.id = ?1");
        qr.setParameter(1, id);
        return (Greeting) qr.getSingleResult();
    }
}
