package com.sermo.ksc.service;

import com.sermo.ksc.doman.SystemSetting;

/**
 * @author sermo
 * @version 2016/12/15.
 */
public interface SystemSettingServer {

    SystemSetting find();

    boolean update(SystemSetting systemSetting);
}
