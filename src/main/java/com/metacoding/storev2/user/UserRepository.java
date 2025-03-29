package com.metacoding.storev2.user;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

}
