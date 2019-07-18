package cn.pawn.ratel.shiroconfig;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @ClassName MyFormAuthenticationFilter
 * @Description 解决登陆成功后的跳转问题
 * @Author zengyejun
 * @Date 2019-07-17 16:26:37
 **/
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
    /**
     * 因为发现设置的successUrl没生效，所以追踪源码发现如果SavedRequest对象不为null,则它会覆盖掉我们设置
     * 的successUrl，所以我们要重写onLoginSuccess方法，在它覆盖掉我们设置的successUrl之前，去除掉
     * SavedRequest对象,SavedRequest对象的获取方式为：
     * savedRequest = (SavedRequest) session.getAttribute(SAVED_REQUEST_KEY);
     * public static final String SAVED_REQUEST_KEY = "shiroSavedRequest";
     * 解决方案：从session对象中移出shiroSavedRequest
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {

        if (!StringUtils.isEmpty(getSuccessUrl())) {
            // getSession(false)：如果当前session为null,则返回null,而不是创建一个新的session
            Session session = subject.getSession(false);
            if (session != null) {
                session.removeAttribute("shiroSavedRequest");
            }
        }
        return super.onLoginSuccess(token, subject, request, response);
    }
}
