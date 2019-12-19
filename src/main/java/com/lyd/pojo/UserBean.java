package com.lyd.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @Author:Lyd
 * @Date 2019/12/13 10:43
 * @Description
 */
public class UserBean {
    /**
     * @JsonProperty("myName"):指定别名
     * @JsonInclude(Include.NON_NULL):为空的时候不显示该字段，注意是null的时候
     */
    @JsonProperty("myName")
    @JsonInclude(Include.NON_NULL)
    private String name;
    private int age;
    /**
     @JsonIgnore屏蔽该参数
     */
    @JsonIgnore
    private String address;
    /**
     * 设置日期格式
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
    private Date createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public UserBean(String name, int age, String address, Date createTime) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.createTime = createTime;
    }
}
