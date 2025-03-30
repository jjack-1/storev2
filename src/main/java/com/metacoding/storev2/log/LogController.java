package com.metacoding.storev2.log;

import java.util.List;

import com.metacoding.storev2.user.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;
    private final HttpSession session;

    @GetMapping("/log")
    public String list(HttpServletRequest request) {
        User user = (User) session.getAttribute("sessionUser");

        // 로그인을 하지 않으면 홈으로 리다이렉트
        if (user == null) return "redirect:/";

        List<LogResponse.LogListItemDTO> logListItemDTOList = logService.구매목록(user);

        request.setAttribute("models", logListItemDTOList);

        return "/log/list";
    }

    @PostMapping("/log/save")
    public String save(LogRequest.LogDTO logDTO) {
       User user = (User) session.getAttribute("sessionUser");

        // 로그인을 하지 않으면 상품상세로 리다이렉트
        if (user == null) return "redirect:/store/" + logDTO.getStoreId();

        logService.구매하기(logDTO, user);
        return "redirect:/log";
    };
}
