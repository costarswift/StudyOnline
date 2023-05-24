package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.CourseTeacherDto;
import com.xuecheng.content.model.po.CourseTeacher;

import java.util.List;

/**
 * @description 课程师资信息管理业务接口
 * @author Costar
 * @date 2023年5月23日 14点35分
 * @version 1.0
 */
public interface CourseTeacherService {
    /**
     * @description 根据课程ID查询课程师资信息
     * @author Costar
     * @date 2023年5月23日 14点35分
     * @version 1.0
     */
    List<CourseTeacher> queryCourseTeacherById(long courseId);

    CourseTeacher creatCourseTeacher(CourseTeacherDto courseTeacherDto);

    CourseTeacher editCourseTeacher (CourseTeacherDto courseTeacherDto);

    void deleteTeacherById (long courseId, long teacherId);
}
