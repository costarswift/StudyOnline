package com.xuecheng.content.api;

import com.xuecheng.content.model.dto.BindTeachplanMediaDto;
import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;
import com.xuecheng.content.service.TeachplanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "课程计划编辑接口", tags = "课程计划编辑接口")
@RestController
public class TeachplanController {
    @Autowired
    TeachplanService teachplanService;

    @ApiOperation("查询课程计划树形结构")
    @ApiImplicitParam(value = "courseId", name = "课程id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/teachplan/{courseId}/tree-nodes")
    public List<TeachplanDto> getTreeNodes(@PathVariable Long courseId){
        return teachplanService.findTeachplanTree(courseId);
    }

    @ApiOperation("课程计划创建或修改")
    @PostMapping("/teachplan")
    public void saveTeachplan(@RequestBody SaveTeachplanDto teachplan){
        teachplanService.saveTeachplan(teachplan);
    }

    @DeleteMapping("/teachplan/{teachplanId}")
    @ApiOperation("删除课程计划")
    @ApiImplicitParam(value = "teachplanId", name = "课程计划id", required = true, dataType = "Long", paramType = "path")
    public void deleteTeachplanById(@PathVariable Long teachplanId){
        teachplanService.deleteTeachplanById(teachplanId);
    }

    @PostMapping("/teachplan/movedown/{teachplanId}")
    @ApiOperation("章/节向下移")
    @ApiImplicitParam(value = "teachplanId", name = "课程计划id", required = true, dataType = "Long", paramType = "path")
    public void movedown(@PathVariable Long teachplanId){

    }

    @PostMapping("/teachplan/moveup/{teachplanId}")
    @ApiOperation("章/节向上移")
    @ApiImplicitParam(value = "teachplanId", name = "课程计划id", required = true, dataType = "Long", paramType = "path")
    public void moveup(@PathVariable Long teachplanId){

    }

    @ApiOperation(value = "课程计划和媒资信息绑定")
    @PostMapping("/teachplan/association/media")
    public void associationMedia(@RequestBody BindTeachplanMediaDto bindTeachplanMediaDto){
        teachplanService.associationMedia(bindTeachplanMediaDto);
    }

    @ApiOperation(value = "删除课程计划绑定的媒资视频")
    @DeleteMapping("/teachplan/association/media/{teachplanId}/{mediaId}")
    public void deleteMedia(@PathVariable long teachplanId){
        teachplanService.deleteMedia(teachplanId);
    }

}
