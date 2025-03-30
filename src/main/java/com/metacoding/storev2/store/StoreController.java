package com.metacoding.storev2.store;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @GetMapping("/store")
    public String list(HttpServletRequest request) {
        List<StoreResponse.StoreDTO> storeDTOList = storeService.상품목록();

        request.setAttribute("models", storeDTOList);

        return "/store/list";
    }
}
