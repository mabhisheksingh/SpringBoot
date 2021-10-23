package com.kafkapublisher.KafkaPublisher.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long empID;
    private String empName;
    private String phoneNumber;
}
