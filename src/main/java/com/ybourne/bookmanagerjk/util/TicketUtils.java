package com.ybourne.bookmanagerjk.util;

import com.ybourne.bookmanagerjk.model.Ticket;
import org.joda.time.DateTime;

public class TicketUtils {
    public static Ticket next(int uid){
        Ticket ticket = new Ticket();
        ticket.setTicket(UuidUtils.next());
        ticket.setUserId(uid);

        DateTime expireTime = new DateTime();
        expireTime = expireTime.plusDays(5);
        ticket.setExpiredAt(expireTime.toDate());

        return ticket;
    }


}
