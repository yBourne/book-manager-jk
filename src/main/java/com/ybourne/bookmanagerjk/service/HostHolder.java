package com.ybourne.bookmanagerjk.service;

import com.ybourne.bookmanagerjk.model.User;
import com.ybourne.bookmanagerjk.util.ConcurrentUtils;
import org.springframework.stereotype.Service;

@Service
public class HostHolder {

    public User getUser(){ return ConcurrentUtils.getHost();}

    public void setUser(User user) { ConcurrentUtils.setHost(user); }
}
