package ru.samd82.hiberOne;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);

    List<Product> findAll();

    Product findByTitle(String title);

    void save(Product product);

    void update(Long id, String title);

    void testCache();

}
