package com.xuecheng.content.api;

import com.xuecheng.content.model.dto.CourseTeacherDto;
import com.xuecheng.content.model.po.CourseTeacher;
import com.xuecheng.content.service.CourseTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "教师管理接口", tags = "教师管理接口")
@RestController
public class CourseTeacherController {
    @Autowired
    CourseTeacherService courseTeacherService;

    @GetMapping("/courseTeacher/list/{courseId}")
    @ApiOperation("根据课程ID查询师资信息")
    @ApiImplicitParam(value = "courseId", name = "课程id", required = true, dataType = "Long", paramType = "path")
    public List<CourseTeacher> queryCourseTeacherById(@PathVariable Long courseId) {
        return courseTeacherService.queryCourseTeacherById(courseId);
    }

    @PostMapping("/courseTeacher")
    @ApiOperation("给课程师资中添加/修改教师")
    public CourseTeacher creatOrEditCourseTeacher(@RequestBody CourseTeacherDto courseTeacherDto){
        if (courseTeacherDto.getId() != null){
            //走修改方法
            return courseTeacherService.editCourseTeacher(courseTeacherDto);
        }else{
            //走新增方法
            return courseTeacherService.creatCourseTeacher(courseTeacherDto);
        }
    }

    @DeleteMapping("/courseTeacher/course/{courseId}/{teacherId}")
    @ApiOperation("根据id删除课程中的教师信息")
    public void deleteTeacherById(@PathVariable Long courseId, @PathVariable Long teacherId){
        courseTeacherService.deleteTeacherById(courseId, teacherId);
    }
}
