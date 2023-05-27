package com.xuecheng.content.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@ApiModel(value = "CourseTeacherDto", description = "新增/编辑课程师资信息")
public class CourseTeacherDto {

    @ApiModelProperty(value = "教师Id")
    private Long id;

    @ApiModelProperty(value = "课程Id", required = true)
    private Long courseId;

    @NotEmpty(message = "教师姓名不能为空")
    @ApiModelProperty(value = "教师姓名", required = true)
    private String teacherName;

    @NotEmpty(message = "教师职位不能为空")
    @ApiModelProperty(value = "教师职位", required = true)
    private String position;

    @NotEmpty(message = "教师介绍不能为空")
    @ApiModelProperty(value = "教师介绍", required = true)
    @Size(message = "教师介绍内容过少", min = 10)
    private String introduction;

    @ApiModelProperty(value = "教师照片")
    private String photograph;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime creatDate;
}
