package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 没有登录或者登录失败的时候进入
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String Login(HttpServletRequest req) throws Exception{
        String err=(String) req.getAttribute("shiroLoginFailure");
        if(err!=null){
            if(err.equals("org.apache.shiro.authc.UnknownAccountException")){
                throw  new Exception("用户名不存在");
            }else if(err.equals("org.apache.shiro.authc.IncorrectCredentialsException")){
                throw  new Exception("密码错误");
            }else{
                System.out.println(err);
                throw  new Exception("未知异常");
            }
        }
        return "/login";
    }
}
