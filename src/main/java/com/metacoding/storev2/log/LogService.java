package com.metacoding.storev2.log;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacoding.storev2.log.LogResponse.LogListItemDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    public List<LogListItemDTO> 구매목록() {
        return logRepository.findAllJoinStoreJoinUser();
    }
}
