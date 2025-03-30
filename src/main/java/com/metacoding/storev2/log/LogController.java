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
        List<LogResponse.LogListItemDTO> logListItemDTOList = logService.구매목록();

        request.setAttribute("models", logListItemDTOList);

        return "/log/list";
    }

    @PostMapping("/log/save")
    public String save(LogRequest.LogDTO logDTO) {
       User user = (User) session.getAttribute("sessionUser");
        logService.구매하기(logDTO, user);
        return "redirect:/log";
    };
}
