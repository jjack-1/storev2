package com.metacoding.storev2.store;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;
}
