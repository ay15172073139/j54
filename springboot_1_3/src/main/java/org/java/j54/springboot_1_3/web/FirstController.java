package org.java.j54.springboot_1_3.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/init")
    public String load(){
        return "hello 123";
    }
}
