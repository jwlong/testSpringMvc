package com.dxfjyygy.service.Impl;


import com.dxfjyygy.dao.SystemConfigMapper;
import com.dxfjyygy.model.SystemConfig;
import com.dxfjyygy.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemConfigServiceImpl implements SystemConfigService {

    @Autowired
    private SystemConfigMapper systemConfigMapper;

    @Override
    public SystemConfig getSystemConfigByValue(String tSysCfgnValue) {
        return systemConfigMapper.getSystemConfigByValue(tSysCfgnValue);
    }
}
