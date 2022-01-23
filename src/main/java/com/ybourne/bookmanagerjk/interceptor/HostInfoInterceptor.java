package com.ybourne.bookmanagerjk.interceptor;

import com.ybourne.bookmanagerjk.model.Ticket;
import com.ybourne.bookmanagerjk.model.User;
import com.ybourne.bookmanagerjk.service.TicketService;
import com.ybourne.bookmanagerjk.service.UserService;
import com.ybourne.bookmanagerjk.util.ConcurrentUtils;
import com.ybourne.bookmanagerjk.util.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class HostInfoInterceptor implements HandlerInterceptor {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String t = CookieUtils.getCookies("t", request);
        if (!StringUtils.isEmpty(t)){
            Ticket ticket = ticketService.getTicket(t);
            if (ticket != null && ticket.getExpiredAt().before(new Date())){
                User user = userService.getUser(ticket.getUserId());
                ConcurrentUtils.setHost(user);
            }
        }
        return true;
    }
}
