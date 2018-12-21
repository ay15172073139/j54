package org.java.web;

import org.java.entity.UserInfo;
import org.java.service.CartService;
import org.java.service.PrdService;
import org.java.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.pkcs11.P11Util;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class PrdController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private PrdService prdService;


    @Autowired
    private CartService cartService;

    @RequestMapping("/logout")
    public String logout(HttpSession ses){
        ses.removeAttribute("userId");
        return "redirect:/loadPrd";
    }

    @RequestMapping("/showCart")
    public String showCart(Model model){
        List<Map> list=cartService.getCart();
        model.addAttribute("list", list);
        Integer zong=0;
        for (Map m: list) {
          zong+=(Integer) m.get("amount")*(Integer) m.get("price");
        }
        model.addAttribute("zong", zong);
        return "show";
    }

    @RequestMapping("/delallCart")
    public String delallCart(){
        cartService.delallCart();
        return "redirect:/showCart";
    }

    @RequestMapping("/addCart")
    public String addCart(@RequestParam("id") Integer id){
        Map cart=cartService.getCartById(id);
        if (cart==null){
            Map m=prdService.findById(id);
            m.put("amount", 1);
            cartService.add(m);
        }else{
            cart.put("amount", (Integer)cart.get("amount")+1);
            cartService.update(cart);
        }
        return "redirect:/loadPrd";
    }


    @RequestMapping("/updateCart")
    public String Remove(@RequestParam("id") Integer id,@RequestParam("type") Integer type){
        Map cart=cartService.getCartById(id);
        if(type.equals(1)){
            cart.put("amount", (Integer)cart.get("amount")+1);
            cartService.update(cart);
        }else if(type.equals(2)){
            cart.put("amount", (Integer)cart.get("amount")-1);
            cartService.update(cart);
        }else if(type.equals(3)){
            cartService.delById(id);
        }
        return "redirect:/showCart";
    }

    @PostMapping("/login")
    public String login(HttpSession ses,String uname,String upwd,Model model){
        UserInfo user=userInfoService.findUser(uname);
        String msg="";
        if(user==null){
            msg="此用户不存在";
            ses.setAttribute("msg", msg);
        }else if(!user.getUpwd().equals(upwd)){
            msg="密码错误";
            ses.setAttribute("msg", msg);
        }else{
            ses.setAttribute("userId", uname);
            ses.removeAttribute("msg");
        }
        return "redirect:/loadPrd";
    }


    @RequestMapping("/loadPrd")
    public  String loadPrd(Model model, @RequestParam(name="currPage",required = false) Integer currPage, HttpSession ses){
        if(currPage==null) {
            currPage = 1;
        }

        int size=5;
        int count= prdService.getTotal();
        int maxPage=(count-1)/size+1;
        List<Map> list=prdService.getList(currPage,size);
        model.addAttribute("list",list );
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("currPage",currPage);
        model.addAttribute("count", count);
        model.addAttribute("size", size);
        ses.setAttribute("currPage", currPage);
        return "index";
    }


}
