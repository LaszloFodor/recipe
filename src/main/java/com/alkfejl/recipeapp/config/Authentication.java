package com.alkfejl.recipeapp.config;

import com.alkfejl.recipeapp.model.User;
import com.alkfejl.recipeapp.service.UserServiceImp;
import com.alkfejl.recipeapp.service.annotations.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.method.HandlerMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Handler;

@Component
public class Authentication extends HandlerInterceptorAdapter {

    @Autowired
    private UserServiceImp userServiceImp;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        List<User.Role> routeRoles = getRoles((HandlerMethod) handler);
        User user = userServiceImp.getUser();

        if (routeRoles.isEmpty() || routeRoles.contains(User.Role.GUEST)) {
            return true;
        }

        if (userServiceImp.isLoggedIn() && routeRoles.contains(user.getRole())) {
            return true;
        }

        response.setStatus(401);
        return false;
    }


    public List<User.Role> getRoles(HandlerMethod handler) {
        Role role = handler.getMethodAnnotation(Role.class);
        return role == null ? Collections.emptyList() : Arrays.asList(role.value());
    }
}
