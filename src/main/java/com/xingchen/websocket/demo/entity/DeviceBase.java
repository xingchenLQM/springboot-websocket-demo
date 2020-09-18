package com.xingchen.websocket.demo.entity;

import lombok.Data;

/**
 * 设备类
 */
@Data
public class DeviceBase {

    /**
     * 设备id
     */
    private Long deviceId;

    /**
     * 设备代码
     */
    private String deviceCode;

    /**
     * 设备厂家
     */
    private String factoryName;

    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * 设备型号
     */
    private String model;

    /**
     * 软件版本号
     */
    private String softVersion;

    /**
     * 初始版本号
     */
    private String headVersion;

}
