package com.metacoding.storev2.store;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StoreResponse {

    @Data
    @AllArgsConstructor
    public static class StoreListItemDTO {

        private int id;
        private String name;
    }

    @Data
    @AllArgsConstructor
    public static class StoreDetailDTO {

        private int id;
        private String name;
        private int stock;
        private int price;
    }
}
