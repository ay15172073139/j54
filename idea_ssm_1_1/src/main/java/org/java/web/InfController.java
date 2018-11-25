package org.java.web;

import org.java.service.InfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class InfController {

    @Autowired
    private InfService infService;

    @RequestMapping("/load")
    public  String load(Model model){
        List<Map<String,Object>> list=infService.getList();
        model.addAttribute("list",list);
        return "/show";
    }

}
