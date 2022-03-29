package com.test.myapp.tester;

import com.test.myapp.Persons;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Singleton
@LocalBean
@Startup
public class MyTester {

    @PersistenceContext(name = "com.test_MyApp_ejb_1.0-SNAPSHOTPU")
    EntityManager em;

    @PostConstruct
    public void myMain() {
        TypedQuery<Persons> query = em.createQuery("select a from Persons a where a.city like :param", Persons.class);
        query.setParameter("param", "iz%");
        java.util.List<Persons> list = query.getResultList();

        for (Persons obj : list) {
            System.out.println(obj.getFirstName() + "--" + obj.getLastName() + "--" + obj.getAddress() + "--" + obj.getCity());
        }

    }
}
