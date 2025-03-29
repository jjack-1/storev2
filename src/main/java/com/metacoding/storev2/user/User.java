package com.metacoding.storev2.user;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "user_tb")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, length = 12)
    private String username; // 계정 아이디
    @Column(nullable = false)
    private String fullname; // 계정 닉네임
    @Column(nullable = false, length = 12)
    private String password; // 계정 비밀번호
    private Timestamp createdAt;
}
