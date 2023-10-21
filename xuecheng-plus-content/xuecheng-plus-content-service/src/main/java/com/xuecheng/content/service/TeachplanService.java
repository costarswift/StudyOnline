package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.BindTeachplanMediaDto;
import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;
import com.xuecheng.content.model.po.TeachplanMedia;

import java.util.List;

/**
 * @description 课程基本信息管理业务接口
 * @author Costar
 * @date 2023年5月23日 12点40分
 * @version 1.0
 */

public interface TeachplanService {
    /**
     * @description 查询课程计划树型结构
     * @param courseId  课程id
     * @return List<TeachplanDto>
     * @author Costar
     * @date 2023年5月23日 12点40分
     */
    public List<TeachplanDto> findTeachplanTree(long courseId);

    /**
     * @description 只在课程计划
     * @param teachplanDto  课程计划信息
     * @return void
     * @author Costar
     * @date 2023年5月23日 13点02分
     */
    public void saveTeachplan(SaveTeachplanDto teachplanDto);

    /**
     * @description 根据课程计划Id删除章/节
     * @param teachplanId  课程Id
     * @return void
     * @author Costar
     * @date 2023年5月23日 13点02分
     */
    public void deleteTeachplanById(long teachplanId);

    /**
     * @description 将章/节向下移动
     * @param teachplanId  课程Id
     * @return void
     * @author Costar
     * @date 2023年5月23日 14点04分
     */
    public void movedown(long teachplanId);

    /**
     * @description 将章/节向上移动
     * @param teachplanId  课程Id
     * @return void
     * @author Costar
     * @date 2023年5月23日 14点04分
     */
    public void moveup(long teachplanId);

    /**
     * @description 教学计划绑定媒资
     * @param bindTeachplanMediaDto
     * @return com.xuecheng.content.model.po.TeachplanMedia
     * @author Costar
     * @date 2023年6月12日 15点42分
     */
    TeachplanMedia associationMedia(BindTeachplanMediaDto bindTeachplanMediaDto);

    void deleteMedia(long teachplanId);
}
