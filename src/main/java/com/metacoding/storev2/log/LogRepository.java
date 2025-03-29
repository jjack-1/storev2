package com.metacoding.storev2.log;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LogRepository {
    private final EntityManager em;
}
