package com.herbalmanagement.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
//    目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录检查逻辑
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null){
            //登录成功的状态，放行
            return true;
        }
        //拦截住。即未登录，跳转到登录页
        request.setAttribute("msg","请先登录");
//re.sendRedirect("/");//重定向不能取出session会话域里的信息，所以在请求域中放信息，用转发方式
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }
}
