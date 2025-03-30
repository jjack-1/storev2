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

    public Store findById(int id) {
        Query query = em.createNativeQuery("select * from store_tb where id = ?", Store.class);
        query.setParameter(1, id);

        try {
            return (Store) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteById(int id) {
        Query query = em.createNativeQuery("delete from store_tb where id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }
}
