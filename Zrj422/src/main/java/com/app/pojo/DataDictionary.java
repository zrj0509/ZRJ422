package com.app.pojo;


import lombok.Data;

@Data
public class DataDictionary {
    private int id;
    private String typeCode;
    private String typeName;
    private int valueId;
    private String valueName;
    private int createBy;
    private String creationDate;
    private int modifyBy;
    private String modifyDate;
}
