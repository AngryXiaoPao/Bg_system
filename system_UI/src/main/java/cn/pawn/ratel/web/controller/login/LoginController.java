package cn.pawn.ratel.web.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginController
 * @Description 登录控制页
 * @Author zengyejun
 * @Date 2019-07-03 14:19:21
 **/
@Controller
public class LoginController {
    private String prefix = "login";

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        return prefix+"/login";
    }

    public String index(){
        return prefix+"/index";
    }

}
