package org.java.j54.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/init")
    public String init(){
        System.out.println("进入加载方法!!!!!!!!!!!");
        return "hello World!";
    }
}
