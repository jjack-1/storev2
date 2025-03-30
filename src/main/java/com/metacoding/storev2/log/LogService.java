package com.metacoding.storev2.log;

import java.util.List;

import com.metacoding.storev2.store.Store;
import com.metacoding.storev2.store.StoreRepository;
import com.metacoding.storev2.user.User;
import org.springframework.stereotype.Service;

import com.metacoding.storev2.log.LogResponse.LogListItemDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;
    private final StoreRepository storeRepository;

    public List<LogListItemDTO> 구매목록(User user) {
        return logRepository.findAllByUserIdJoinStoreJoinUser(user.getId());
    }

    @Transactional
    public void 구매하기(LogRequest.LogDTO logDTO, User user) {
        // 1. 상품 재고 수정 (조회, 수정)
        // 1-1. 조회
        Store store = storeRepository.findById(logDTO.getStoreId());
        if(store == null) throw new RuntimeException("해당 상품이 존재하지 않습니다");

        // 1-2. 재고 상태 변경
        store.재고감소(logDTO.getQty());

        // 1-3. 재고 수정
        storeRepository.updateById(store.getId(), store.getName(), store.getStock(), store.getPrice());

        // 2. 구매 기록 하기
        logRepository.save(user.getId(),logDTO.getStoreId(), logDTO.getQty(), logDTO.getQty() * store.getPrice());
    }
}
