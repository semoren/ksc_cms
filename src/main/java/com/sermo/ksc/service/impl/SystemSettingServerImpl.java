package com.sermo.ksc.service.impl;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.sermo.ksc.doman.SystemSetting;
import com.sermo.ksc.doman.SystemSettingRepository;
import com.sermo.ksc.service.SystemSettingServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sermo
 * @version 2016/12/15.
 */
@Service
public class SystemSettingServerImpl implements SystemSettingServer{

    @Resource
    private SystemSettingRepository repository;

    @Override
    public SystemSetting find() {
        return repository.find();
    }

    @Override
    public boolean update(SystemSetting systemSetting) {
        try {
            return repository.update(systemSetting) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
