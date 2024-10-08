package com.irijeoriyorijori.lounge.controller.main;

import com.irijeoriyorijori.lounge.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class MainViewController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String main() {
        return "main";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }


//    @GetMapping("/review")
//    public String review() {
//        return "review/reviewList";
//    }


    @GetMapping("test")
    public String test() {
        return "layout/layout";
    }


//    @GetMapping("/report")
//    public String report(@RequestParam(name="device") String device) {
//        return "reports/reports";
//    }

    @GetMapping("/main")
    public String mainPage(HttpSession session, Model model) {


        String userId = (String)session.getAttribute("userId");
        boolean isLoggedIn = userId != null;


//        boolean isLoggedIn = session.getAttribute("userId") != null;
        model.addAttribute("isLoggedIn", isLoggedIn);

        if (!isLoggedIn) {
            return "redirect:/login";  // 로그인이 필요할 경우 로그인 페이지로 리다이렉트
        }
        return "main";  // main.html 템플릿 반환
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // 세션 무효화
        return "redirect:/";    // 로그아웃 후 메인 페이지로 리다이렉트
    }

}

