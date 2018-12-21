package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class FirstController {

    @GetMapping("/init")
    public String init(){
        System.out.println("进入主界面");
        return "/main";
    }

}
