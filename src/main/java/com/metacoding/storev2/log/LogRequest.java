package com.metacoding.storev2.log;

import lombok.Data;

public class LogRequest {

    @Data
    public static class LogDTO{
        private int storeId;
        private int qty;
    }
}
