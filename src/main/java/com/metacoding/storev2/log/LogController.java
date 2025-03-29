package com.metacoding.storev2.log;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;
}
