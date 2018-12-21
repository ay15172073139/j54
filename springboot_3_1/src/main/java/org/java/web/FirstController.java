package org.java.web;

import org.java.entity.Inf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FirstController {
    @GetMapping("/init")
    public String init(Model model){
        model.addAttribute("msg", "helloworld");
        Inf f=new Inf(1,"jack",23);
        model.addAttribute("f", f);
        Map m=new HashMap();
        m.put("k", "111111111");
        m.put("v", "22222222");
        model.addAttribute("m", m);

        model.addAttribute("path", "img/xz.jpg");
        model.addAttribute("path2", "xz.jpg");


        List<Inf> list=new ArrayList<>();
        for (int i=1;i<=10;i++){
            Inf inf=new Inf(i,"name"+i,i+20);
            list.add(inf);
        }
        model.addAttribute("list", list);
        return "index";
    }

    @GetMapping("/del/{id}")
    public String del(@PathVariable("id") Integer id,Model m){
        m.addAttribute("msg", "要删除的id是:"+id);
        return "show";
    }

}
