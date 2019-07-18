package cn.pawn.ratel.web.controller.login;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName LoginController
 * @Description 登录控制页
 * @Author zengyejun
 * @Date 2019-07-03 14:19:21
 **/
@Controller
@Slf4j
public class LoginController {

    @PostMapping("/signin")
    public String signin(String username, String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, false);
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            // 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            // 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            // 所以这一步在调用login(token)方法时,它会走到xxRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            currentUser.login(token);
            return "redirect:/index";
        } catch (Exception e) {
            log.error("登录失败，用户名[{}]", username, e);
            token.clear();
            return "redirect:/error/LoginFailed";
        }
    }
}
