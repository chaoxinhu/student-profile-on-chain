package org.fiscobcos.quiz.base;

import java.util.List;
import lombok.Data;

@Data
public class IdInfo {

    String owner;
    String name;
    String sid;
    Integer birthDate;
    Boolean gender;
    List<TrainingRecord> trainingRecords;
}
