package com.metacoding.storev2.log;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "log_tb")
@Getter
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int storeId;
    private int qty; // 구매 수량
    private int totalPrice; // 총 가격
    private Timestamp createdAt;
}
