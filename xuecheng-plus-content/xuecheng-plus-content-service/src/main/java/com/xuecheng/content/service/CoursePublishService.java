package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.CoursePreviewDto;

/**
 * @Project StudyOnline
 * @Package com.xuecheng.content.service
 * @Name CoursePublishService
 * @Version 1.0
 * @Description TODO
 * @Author Costar
 * @Date 2023-06-12 下午 4:42
 */
public interface CoursePublishService {
    /**
     * @description 获取课程预览信息
     * @param courseId 课程id
     * @return com.xuecheng.content.model.dto.CoursePreviewDto
     * @author Costar
     * @date 2023年6月12日 16点43分
     */
    public CoursePreviewDto getCoursePreviewInfo(Long courseId);

}
