package com.metacoding.storev2.log;

import lombok.AllArgsConstructor;
import lombok.Data;

public class LogResponse {

    @Data
    @AllArgsConstructor
    public static class LogListItemDTO {
        private int id;
        private String buyer; // 구매자 이름
        private String name; // 구매되는 상품 이름
        private int qty; // 구매 수량
        private int totalPrice; // 총 가격
    }
}
