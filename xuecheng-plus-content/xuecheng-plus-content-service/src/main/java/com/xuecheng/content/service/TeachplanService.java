package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;

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

}
