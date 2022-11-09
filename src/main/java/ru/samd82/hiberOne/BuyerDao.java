package ru.samd82.hiberOne;

import java.util.List;

public interface BuyerDao {

    Buyer findById(Long id);

    List<Buyer> findAll();

    Buyer findByTitle(String title);

    void save(Buyer buyer);

    void update(Long id, String title);



}
