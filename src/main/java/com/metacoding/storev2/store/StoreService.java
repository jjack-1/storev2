package com.metacoding.storev2.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacoding.storev2.store.StoreRequest.StoreDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public List<StoreResponse.StoreListItemDTO> 상품목록() {
        // 1. 테이블에서 store list를 가져온다
        List<Store> storeList = storeRepository.findAll();

        // 2. Store -> StoreDTO 변환한다
        List<StoreResponse.StoreListItemDTO> storeDTOList = new ArrayList<>();

        for (Store store : storeList) {
            storeDTOList.add(new StoreResponse.StoreListItemDTO(store.getId(), store.getName()));
        }

        return storeDTOList;
    }

    public StoreResponse.StoreDetailDTO 상품상세(int id) {
        // 1. 상품 확인
        Store store = storeRepository.findById(id);

        // 2. 상품이 없으면 예외!
        if (store == null) {
            throw new RuntimeException("해당 상품이 없습니다");
        }

        return new StoreResponse.StoreDetailDTO(store.getId(), store.getName(), store.getStock(), store.getPrice());
    }

    @Transactional
    public void 상품삭제(int id) {
        // 1. 상품 확인
        Store store = storeRepository.findById(id);

        // 2. 상품이 없으면 예외!
        if (store == null) {
            throw new RuntimeException("해당 상품이 없습니다");
        }

        storeRepository.deleteById(id);
    }

    @Transactional
    public void 상품수정(int id, StoreRequest.StoreDTO storeDTO) {
        // 1. 상품 확인
        Store store = storeRepository.findById(id);

        // 2. 상품이 없으면 예외!
        if (store == null) {
            throw new RuntimeException("해당 상품이 없습니다");
        }

        storeRepository.updateById(id, storeDTO.getName(), storeDTO.getStock(), storeDTO.getPrice());
    }

    @Transactional
    public void 상품등록(StoreRequest.StoreDTO storeDTO) {
        storeRepository.save(storeDTO.getName(), storeDTO.getStock(), storeDTO.getPrice());
    }
}
