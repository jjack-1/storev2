package com.metacoding.storev2.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class JoinDTO {
        private String username;
        private String fullname;
        private String password;
    }

    @Data
    public static class LoginDTO {
        private String username;
        private String password;
    }
}