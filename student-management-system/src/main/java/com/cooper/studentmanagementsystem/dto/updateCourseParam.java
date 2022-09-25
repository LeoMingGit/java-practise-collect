package com.cooper.studentmanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
public class updateCourseParam {

    /**
     *
     */
    @NotNull
    private Integer id;
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
