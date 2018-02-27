package service;

import domain.Person;
import jpa.EntityManagerHelper;

import javax.persistence.EntityTransaction;

public class PersonDAO implements GenericDAO<Person, Long> {


    public Person create(Person person) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().persist(person);
        t.commit();
        return person;
    }

    public Person read(Long id) {
        return EntityManagerHelper.getEntityManager().find(Person.class, id);
    }

    public Person update(Person person) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().merge(person);
        t.commit();
        return person;
    }

    public void delete(Person person) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().remove(person);
        t.commit();
    }
}
