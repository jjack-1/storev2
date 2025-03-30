package com.metacoding.storev2.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(UserRequest.joinDTO joinDTO) {
        // 1. 동일 username 있는지 확인
        User user = userRepository.findByUsername(joinDTO.getUsername());

        if (user != null) {
            // 2. 있으면, exception! 오류는 exception으로 처리한다
            throw new RuntimeException("동일한 username이 있습니다");
        }

        // 3. 없으면 회원가입 성공
        userRepository.save(joinDTO.getUsername(), joinDTO.getFullname(), joinDTO.getPassword());
    }

    public User 로그인(UserRequest.loginDTO loginDTO) {
        // 1. username이 있는지 확인
        User user = userRepository.findByUsername(loginDTO.getUsername());

        if (user == null) {
            // 2. 없으면, exception! 오류는 exception으로 처리한다
            throw new RuntimeException("해당 아이디가 없습니다");
        }

        // 3. password가 동일한지 확인
        if (!(loginDTO.getPassword().equals(user.getPassword()))) {
            throw new RuntimeException("비밀번호가 틀렸습니다");
        }

        return user;
    }
}
