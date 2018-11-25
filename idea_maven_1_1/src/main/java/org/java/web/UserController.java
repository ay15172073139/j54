package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/login")
    public String login(){
        System.out.println("进入@@@@@@@@@@@@####################");
        return "/show";
    }

}
