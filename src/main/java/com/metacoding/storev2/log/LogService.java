package com.metacoding.storev2.log;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;
}
