package org.example.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SessionController {
//    상태정보로 유지하고 싶은 값을 받아오는 화면 요청
    @GetMapping("/sessionForm")
    public String sessionForm() {
        return "session_form";
    }

    @GetMapping("/addSession")
    public String addSession(@RequestParam("sessionKey") String sessionKey,
                             @RequestParam("sessionValue")String sessionValue,
                             HttpSession session) {

        session.setAttribute(sessionKey, sessionValue);
        return  "redirect:/sessionView";
    }
    @GetMapping("/sessionView")
    public String sessionView(HttpSession session, Model model) {

//        세션이 저장한 모든 값을 출력한다라고 하면..
        Map<String, Object> map = new HashMap<String, Object>();

        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            Object attributeValue = session.getAttribute(attributeName);
            map.put(attributeName, attributeValue);
        }

        model.addAttribute("session", map);
//        System.out.println(map.size());
        return "session_view";

    }
}
