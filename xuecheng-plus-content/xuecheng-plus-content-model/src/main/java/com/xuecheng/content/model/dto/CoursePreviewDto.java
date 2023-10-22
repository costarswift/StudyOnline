package com.xuecheng.content.model.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Project StudyOnline
 * @Package com.xuecheng.content.model.dto
 * @Name CoursePreviewDto
 * @Version 1.0
 * @Description TODO
 * @Author Costar
 * @Date 2023-06-12 下午 4:41
 */

@Data
@ToString
public class CoursePreviewDto {
    //课程基本信息,课程营销信息
    CourseBaseInfoDto courseBase;


    //课程计划信息
    List<TeachplanDto> teachplans;

    //师资信息暂时不加...

}
