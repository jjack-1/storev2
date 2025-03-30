package com.metacoding.storev2.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public List<StoreResponse.StoreDTO> 상품목록() {
        // 1. 테이블에서 store list를 가져온다
        List<Store> storeList = storeRepository.findAll();

        // 2. Store -> StoreDTO 변환한다
        List<StoreResponse.StoreDTO> storeDTOList = new ArrayList<>();

        for (Store store : storeList) {
            storeDTOList.add(new StoreResponse.StoreDTO(store.getId(), store.getName()));
        }

        return storeDTOList;
    }
}
