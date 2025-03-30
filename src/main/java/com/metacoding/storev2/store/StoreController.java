package com.metacoding.storev2.store;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @GetMapping("/store")
    public String list(HttpServletRequest request) {
        List<StoreResponse.StoreListItemDTO> storeListItemList = storeService.상품목록();

        request.setAttribute("models", storeListItemList);

        return "/store/list";
    }

    @GetMapping("/store/{id}")
    public String detail(
            HttpServletRequest request,
            @PathVariable("id") int id) {
        StoreResponse.StoreDetailDTO storeDetailDTO = storeService.상품상세(id);

        request.setAttribute("model", storeDetailDTO);

        return "/store/detail";
    }
}
