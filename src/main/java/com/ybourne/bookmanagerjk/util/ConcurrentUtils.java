package com.ybourne.bookmanagerjk.util;


import com.ybourne.bookmanagerjk.model.User;

public class ConcurrentUtils {
    public static ThreadLocal<User> host = new ThreadLocal<>();

    public static void setHost(User user){ host.set(user); }

    public static User getHost() { return host.get(); }
}
