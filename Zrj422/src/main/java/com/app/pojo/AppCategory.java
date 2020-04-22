package com.app.pojo;

import lombok.Data;

@Data
public class AppCategory {
    private int id;
    private String categoryCode;
    private String categoryName;
    private int parentId;
    private int createdBy;
    private String creationTime;
    private int modifyBy;
    private String modifyDate;
}
