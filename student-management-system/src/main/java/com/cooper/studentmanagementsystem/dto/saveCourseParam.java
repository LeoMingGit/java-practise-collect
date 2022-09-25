package com.cooper.studentmanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
/**
 *
 */
@Getter
@Setter
public class saveCourseParam {
    /**
     *
     */
    @NotEmpty
    private String courseno;

    /**
     *
     */
    @NotEmpty
    private String coursename;
}
