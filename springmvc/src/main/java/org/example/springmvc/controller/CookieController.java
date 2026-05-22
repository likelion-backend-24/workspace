package org.example.springmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class CookieController {
//    사용자로부터 상태정보로 저장 하고 싶은 값을 받아오는 것으로!!  (실제는 서버에서 처리 할꺼예요.)
    @GetMapping("/cookieForm")
    public String cookieForm(){
        return "cookie_form";
    }
    @GetMapping("/addcookie")
    public String addcookie(@RequestParam String cookieName,
                            @RequestParam String cookieValue, HttpServletResponse response){
        log.info("cookieName - {}, cookieValue - {}", cookieName, cookieValue);
//        상태정보를 유지할 쿠키객체 생성.
        Cookie cookie = new Cookie(cookieName,cookieValue);
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24);

//        반드시 응답객체에 실어서 클라이언트(브라우저)에 전달 해야함.
        response.addCookie(cookie);

        return "redirect:/cookieView";
    }

    @GetMapping("/cookieView")
    public String cookieView(HttpServletRequest request, Model model){
        Cookie[] cookies = request.getCookies();
        List<String> cookieList = new ArrayList<>();

        if(cookies != null){
            for(Cookie cookie : cookies){
                log.info(cookie.getName()+":::"+cookie.getValue());
                cookieList.add(cookie.getName()+":::"+cookie.getValue());
            }
        }
        model.addAttribute("cookieList",cookieList);

        return "cookie_view";
    }

    @GetMapping("/login")
    public String login(@RequestParam String id, @RequestParam String passwd){
        //서비스단에 보내서 로그인 여부를 체크하겠죠??
//        서비스 쪽에서 true, false 를 리턴하든 알려주겠죠?
        if(true){
            Cookie cookie = new Cookie("loginOK",id);

        }else{

        }

        return "";
    }
}
