package com.example.demo.core.request;

import lombok.Data;
import lombok.EqualsAndHashCode;



@EqualsAndHashCode(callSuper = true)
@Data
public class StudentHomeworkPageRequest extends PageRequest {

    private Long homeworkId;
}