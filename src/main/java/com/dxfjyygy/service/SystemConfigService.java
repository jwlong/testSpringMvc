package com.dxfjyygy.service;


import com.dxfjyygy.model.SystemConfig;

public interface SystemConfigService {

    /**
     * 获取系统配置信息
     * @param tSysCfgnValue
     * @return
     */
    SystemConfig getSystemConfigByValue(String tSysCfgnValue);

}
