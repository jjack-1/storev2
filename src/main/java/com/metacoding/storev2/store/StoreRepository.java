package com.metacoding.storev2.store;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class StoreRepository {
    private final EntityManager em;

    public List<Store> findAll() {
        Query query = em.createNativeQuery("select * from store_tb order by id desc", Store.class);

        return query.getResultList();
    }
}
