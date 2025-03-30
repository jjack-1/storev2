package com.metacoding.storev2.store;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "store_tb")
@Getter
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int stock; // 상품 재고
    private int price; // 상품 가격
    private Timestamp createdAt;

    public void 재고감소(int qty){
        this.stock -= qty;
    }
}
