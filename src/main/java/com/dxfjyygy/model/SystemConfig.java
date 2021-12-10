package com.dxfjyygy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@TableName("t_sys_cfgn")
public class SystemConfig {
    @TableId(value = "t_sys_cfgn_id", type = IdType.AUTO)
    private Long tSysCfgnId;

    private String tCfgnValue;

    private String tCfgnText;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date tLastUpdTime;

    public Long gettSysCfgnId() {
        return tSysCfgnId;
    }

    public void settSysCfgnId(Long tSysCfgnId) {
        this.tSysCfgnId = tSysCfgnId;
    }

    public String gettCfgnValue() {
        return tCfgnValue;
    }

    public void settCfgnValue(String tCfgnValue) {
        this.tCfgnValue = tCfgnValue;
    }

    public String gettCfgnText() {
        return tCfgnText;
    }

    public void settCfgnText(String tCfgnText) {
        this.tCfgnText = tCfgnText;
    }

    public Date gettLastUpdTime() {
        return tLastUpdTime;
    }

    public void settLastUpdTime(Date tLastUpdTime) {
        this.tLastUpdTime = tLastUpdTime;
    }
}
