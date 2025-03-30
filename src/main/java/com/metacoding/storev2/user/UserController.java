package com.metacoding.storev2.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/join-form")
    public String joinForm() {
        return "/user/join-form";
    }

    @PostMapping("/join")
    public String join(UserRequest.joinDTO userDTO) {

        userService.회원가입(userDTO);

        return "redirect:/login-form";
    }

    @GetMapping("/login-form")
    public String loginForm() {
        return "/user/login-form";
    }

    @PostMapping("/login")
    public String login(UserRequest.loginDTO loginDTO) {
        User sessionUser = userService.로그인(loginDTO);

        session.setAttribute("sessionUser", sessionUser); // stateful 서버에 상태를 저장, 머스테치에서도 sessionUser 키값으로 데이터 접근 가능

        return "redirect:/";
    }

    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate(); // session에 있는 정보만 제거

        return "redirect:/";
    }
}