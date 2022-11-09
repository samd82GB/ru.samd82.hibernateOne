package ru.samd82.hiberOne;

import org.hibernate.Session;

import java.util.List;

public class BuyerDaoImpl implements BuyerDao {

    private SessionFactoryUtils sessionFactoryUtils;

    public BuyerDaoImpl(SessionFactoryUtils sessionFactoryUtils){
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Buyer findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.getTransaction().commit();
            return buyer;
        }
    }

    @Override
    public List<Buyer> findAll() {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Buyer> buyers = session.createQuery("SELECT p FROM Buyer p").getResultList();
            session.getTransaction().commit();
            return buyers;
        }
    }

    @Override
    public Buyer findByTitle(String name) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Buyer buyer = session.createQuery("select u from Buyer u where u.name = :name", Buyer.class)
                    .setParameter("name", name)
                    .getSingleResult();
            session.getTransaction().commit();
            return buyer;
        }
    }

    @Override
    public void save(Buyer buyer) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(buyer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Long id, String name) {
       try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            buyer.setName(name);
            session.getTransaction().commit();
        }
    }




}
