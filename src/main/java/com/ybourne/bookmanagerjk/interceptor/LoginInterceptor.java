package com.ybourne.bookmanagerjk.interceptor;


import com.ybourne.bookmanagerjk.model.Ticket;
import com.ybourne.bookmanagerjk.service.TicketService;
import com.ybourne.bookmanagerjk.util.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private TicketService ticketService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception{

        // no ticket, redirect to login page
        String t = CookieUtils.getCookies("t", request);
        if (StringUtils.isEmpty(t)){
            response.sendRedirect("/users/login");
            return false;
        }

        Ticket ticket = ticketService.getTicket(t);
        if (ticket==null) {
            response.sendRedirect("/users/login");
            return false;
        }

        if (ticket.getExpiredAt().after(new Date())){
            response.sendRedirect("/users/login");
            return false;
        }

        return true;
    }
}
