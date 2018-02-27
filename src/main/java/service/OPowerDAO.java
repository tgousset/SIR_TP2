package service;

import domain.OPower;
import jpa.EntityManagerHelper;

import javax.persistence.EntityTransaction;

public class OPowerDAO implements GenericDAO<OPower, Long> {

    public OPower create(OPower oPower) {
        EntityTransaction et = EntityManagerHelper.getEntityManager().getTransaction();
        et.begin();
        EntityManagerHelper.getEntityManager().persist(oPower);
        et.commit();
        return oPower;
    }

    public OPower read(Long id) {
        return EntityManagerHelper.getEntityManager().find(OPower.class, id);
    }

    public OPower update(OPower oPower) {
        EntityTransaction et = EntityManagerHelper.getEntityManager().getTransaction();
        et.begin();
        EntityManagerHelper.getEntityManager().merge(oPower);
        et.commit();
        return oPower;
    }

    public void delete(OPower oPower) {
        EntityTransaction et = EntityManagerHelper.getEntityManager().getTransaction();
        et.begin();
        EntityManagerHelper.getEntityManager().remove(oPower);
        et.commit();
    }
}
