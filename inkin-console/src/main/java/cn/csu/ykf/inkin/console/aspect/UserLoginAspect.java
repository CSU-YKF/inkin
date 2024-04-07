package cn.csu.ykf.inkin.console.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import cn.csu.ykf.inkin.common.model.session.UserSession;
import cn.csu.ykf.inkin.console.cache.SessionCache;
import cn.csu.ykf.inkin.console.exception.NotLoggedInException;
import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class UserLoginAspect {

    @Before("execution(* cn.csu.ykf.inkin.console.controller.image.*.*(..))")
    public void checkUserLogin() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        if (token == null) {
            ModelAndView modelAndView = new ModelAndView("redirect:/login");
            throw new NotLoggedInException("User is not logged in", modelAndView);

        }

        UserSession user = SessionCache.getINSTANCE().getSession(token);
        if (user == null) {
            ModelAndView modelAndView = new ModelAndView("redirect:/login");
            throw new NotLoggedInException("User is not logged in", modelAndView);

        }

        // Add user to request attributes
        RequestContextHolder.getRequestAttributes().setAttribute("user", user, ServletRequestAttributes.SCOPE_REQUEST);
    }
}