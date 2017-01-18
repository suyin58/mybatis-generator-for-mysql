package com.wjs.mybatis.demo.domain.access;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class AccessIpControlConfig implements Serializable {
    /**
     * 标准ID -- access_ip_control_config.id
     * 
     */
    private Long id;

    /**
     * 操作ip -- access_ip_control_config.ip
     * 
     */
    private String ip;

    /**
     * http请求uri -- access_ip_control_config.uri
     * 
     */
    private String uri;

    /**
     * 请求统计时间 -- access_ip_control_config.access_count_duration
     * 
     */
    private Long accessCountDuration;

    /**
     * 最大请求数 -- access_ip_control_config.access_count_max
     * 
     */
    private Integer accessCountMax;

    /**
     * access_ip_control_config表的操作属性:serialVersionUID
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据字段 access_ip_control_config.id的get方法 
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 数据字段 access_ip_control_config.id的set方法
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 数据字段 access_ip_control_config.ip的get方法 
     * 
     */
    public String getIp() {
        return ip;
    }

    /**
     * 数据字段 access_ip_control_config.ip的set方法
     * 
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * 数据字段 access_ip_control_config.uri的get方法 
     * 
     */
    public String getUri() {
        return uri;
    }

    /**
     * 数据字段 access_ip_control_config.uri的set方法
     * 
     */
    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    /**
     * 数据字段 access_ip_control_config.access_count_duration的get方法 
     * 
     */
    public Long getAccessCountDuration() {
        return accessCountDuration;
    }

    /**
     * 数据字段 access_ip_control_config.access_count_duration的set方法
     * 
     */
    public void setAccessCountDuration(Long accessCountDuration) {
        this.accessCountDuration = accessCountDuration;
    }

    /**
     * 数据字段 access_ip_control_config.access_count_max的get方法 
     * 
     */
    public Integer getAccessCountMax() {
        return accessCountMax;
    }

    /**
     * 数据字段 access_ip_control_config.access_count_max的set方法
     * 
     */
    public void setAccessCountMax(Integer accessCountMax) {
        this.accessCountMax = accessCountMax;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}