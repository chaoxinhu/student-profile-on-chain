package org.fiscobcos.quiz.base;

import lombok.Data;


@Data
public class TrainingRecord {
    String issuer;
    Integer type;
    Integer startDate;
    Integer endDate;
    String diplomaAddress;
    Integer timestamp;
}
