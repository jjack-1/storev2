package com.metacoding.storev2.store;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class StoreRepository {
    private final EntityManager em;
}
