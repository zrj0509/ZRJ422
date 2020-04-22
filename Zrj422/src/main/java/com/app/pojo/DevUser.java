package com.app.pojo;

import lombok.Data;

@Data
public class DevUser {
    private int id;
    private String devCode;
    private String devName;
    private String devPassword;
    private String devEmail;
    private String devInfo;
    private int createdBy;
    private String creationDate;
    private int modifyBy;
    private String modifyDate;

}
