package com.metacoding.storev2.store;

import lombok.Data;

public class StoreRequest {

    @Data
    public static class StoreUpdateDTO {
        private String name;
        private int stock;
        private int price;
    }
}
