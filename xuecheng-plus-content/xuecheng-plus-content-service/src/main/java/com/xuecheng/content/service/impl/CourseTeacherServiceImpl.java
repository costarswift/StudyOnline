package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xuecheng.base.exception.XueChengPlusException;
import com.xuecheng.content.mapper.CourseTeacherMapper;
import com.xuecheng.content.model.dto.CourseTeacherDto;
import com.xuecheng.content.model.po.CourseTeacher;
import com.xuecheng.content.service.CourseTeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseTeacherServiceImpl implements CourseTeacherService {
    @Autowired
    CourseTeacherMapper courseTeacherMapper;


    @Override
    public List<CourseTeacher> queryCourseTeacherById(long courseId) {
        //构建查询条件对象
        LambdaQueryWrapper<CourseTeacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CourseTeacher::getCourseId, courseId);
        return courseTeacherMapper.selectList(queryWrapper);
    }

    @Override
    public CourseTeacher creatCourseTeacher(CourseTeacherDto courseTeacherDto) {
        CourseTeacher courseTeacher = new CourseTeacher();
        BeanUtils.copyProperties(courseTeacherDto, courseTeacher);
        courseTeacher.setCreateDate(LocalDateTime.now());
        int i = courseTeacherMapper.insert(courseTeacher);
        if (i != 1) {
            XueChengPlusException.cast("添加教师失败");
        }
        return courseTeacher;
    }

    @Override
    @Transactional
    public CourseTeacher editCourseTeacher(CourseTeacherDto courseTeacherDto) {
        CourseTeacher courseTeacher = new CourseTeacher();
        BeanUtils.copyProperties(courseTeacherDto, courseTeacher);
        courseTeacher.setCreateDate(LocalDateTime.now());
        int i = courseTeacherMapper.updateById(courseTeacher);
        if (i != 1) {
            XueChengPlusException.cast("编辑教师失败");
        }
        return courseTeacher;
    }

    @Override
    public void deleteTeacherById(long courseId, long teacherId) {
        CourseTeacher courseTeacher = courseTeacherMapper.selectById(teacherId);
        if (courseTeacher == null || courseTeacher.getCourseId() != courseId){
            XueChengPlusException.cast("该教师不属于该课程的师资队伍，无法删除！");
        }
        int i = courseTeacherMapper.deleteById(teacherId);
        if (i != 1){
            XueChengPlusException.cast("删除失败！");
        }
    }
}
