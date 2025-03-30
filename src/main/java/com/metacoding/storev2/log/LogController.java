package com.metacoding.storev2.log;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;

    @GetMapping("/log")
    public String list(HttpServletRequest request) {
        List<LogResponse.LogListItemDTO> logListItemDTOList = logService.구매목록();

        request.setAttribute("models", logListItemDTOList);

        return "/log/list";
    }
}
