package com.metacoding.storev2.user;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    public void save(String username, String fullname, String password) {
        Query query = em.createNativeQuery(
                "INSERT INTO user_tb (username, fullname, password, created_at) VALUES (?, ?, ?, now())");
        query.setParameter(1, username);
        query.setParameter(2, fullname);
        query.setParameter(3, password);
        query.executeUpdate();
    }

    public User findByUsername(String username) {
        Query query = em.createNativeQuery(
                "select * from user_tb where username = ?", User.class);
        query.setParameter(1, username);

        try {
            return (User) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
