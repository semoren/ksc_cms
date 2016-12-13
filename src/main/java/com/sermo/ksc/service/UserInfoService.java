package com.sermo.ksc.service;

import com.sermo.ksc.doman.UserInfo;

import java.util.List;

/**
 * @author sermo
 * @version 2016/12/13.
 */
public interface UserInfoService {

    /**
     * 登陆
     * @param email
     * @return
     */
    UserInfo findByEmail(String email);

    /**
     * 注册
     * @param info
     * @return
     */
    boolean register(UserInfo info);

    List<UserInfo> list();

    /**
     * 禁用/启用
     * @param id
     * @param state
     */
    void updateState(String id, Integer state);
}
