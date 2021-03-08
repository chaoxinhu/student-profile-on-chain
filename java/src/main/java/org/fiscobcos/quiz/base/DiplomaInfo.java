package org.fiscobcos.quiz.base;

import lombok.Data;

@Data
public class DiplomaInfo {
    private String owner;
    private String issuer;
    private Long timestamp;
    private Integer type;
    private String name;
    private String sid;
    private String department;
    private String major;
    private Integer startDate;
    private Integer endDate;
    private Boolean revoked;
}
