package ru.samd82.hiberOne;

import org.hibernate.Session;

import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils){
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT p FROM products p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public Product findByTitle(String title) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product products = session.createQuery("select u from products u where u.title = :title", Product.class)
                    .setParameter("title", title)
                    .getSingleResult();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void save(Product product) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Long id, String title) {
        //            session.createQuery("update User u set u.name :name where u.id = :id")
        //                    .setParameter("name", name)
        //                    .setParameter("id", id)
        //                    .executeUpdate();
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setTitle(title);
            session.getTransaction().commit();
        }
    }

    @Override
    public void testCache() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.get(Product.class, 1L);
            session.get(Product.class, 1L);
            session.get(Product.class, 1L);
            session.getTransaction().commit();
        }
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.get(Product.class, 1L);
            session.get(Product.class, 1L);
            session.get(Product.class, 1L);
            session.getTransaction().commit();
        }
    }


}
