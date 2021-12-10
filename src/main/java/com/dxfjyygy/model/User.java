package com.dxfjyygy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * User Entity
 */
@TableName("user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class User implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private long id;
    private String username;
    private String password;
    private String status;
    private Long jobNum;
    private String department;
    @JsonFormat(pattern = "yyyy-mm-dd", timezone = "GMT+8")
    private Date birthday;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getJobNum() {
        return jobNum;
    }

    public void setJobNum(Long jobNum) {
        this.jobNum = jobNum;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", jobNum=" + jobNum +
                ", department='" + department + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
