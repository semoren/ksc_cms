package com.sermo.ksc.service.impl;

import com.sermo.components.biz.util.MD5Util;
import com.sermo.ksc.doman.UserInfo;
import com.sermo.ksc.doman.UserInfoRepository;
import com.sermo.ksc.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sermo
 * @version 2016/12/13.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Resource
    private UserInfoRepository repository;

    @Override
    public UserInfo findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public boolean register(UserInfo info) {
        info.setPassword(MD5Util.encrypt(info.getPassword()));
        return repository.insert(info);
    }

    @Override
    public List<UserInfo> list() {
        return repository.findAll();
    }

    @Override
    public void updateState(String id, Integer state) {
        repository.updateState(id, state);
    }
}
