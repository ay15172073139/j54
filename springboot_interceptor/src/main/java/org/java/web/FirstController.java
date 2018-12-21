package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class FirstController {
    @GetMapping("/init")
    public String init(){
        return "index";
    }


    @GetMapping("/op/add")
    public String add(){
        System.out.println("正在添加数据");
        return "ok";
    }

    @GetMapping("/op/del")
    public String del(){
        System.out.println("正在删除数据");
        return "ok";
    }

    @PostMapping("/login")
    public String login(@RequestParam("name") String name, HttpSession ses){
            ses.setAttribute("userId",name );
            return "/index";
    }
}
