package com.kafkapublisher.KafkaPublisher.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    private Long empID;
    private String empName;
    private String phoneNumbers;
}
