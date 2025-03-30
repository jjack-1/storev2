package com.metacoding.storev2.store;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StoreResponse {

    @Data
    @AllArgsConstructor
    public static class StoreDTO {

        private int id;
        private String name;
    }
}
