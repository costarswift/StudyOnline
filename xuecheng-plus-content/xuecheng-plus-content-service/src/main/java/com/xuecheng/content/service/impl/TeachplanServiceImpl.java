package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xuecheng.base.exception.BaseException;
import com.xuecheng.content.mapper.TeachplanMapper;
import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;
import com.xuecheng.content.model.po.Teachplan;
import com.xuecheng.content.service.TeachplanService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeachplanServiceImpl implements TeachplanService {
    @Autowired
    TeachplanMapper teachplanMapper;

    @Override
    public List<TeachplanDto> findTeachplanTree(long courseId) {
        return teachplanMapper.selectTreeNodes(courseId);
    }

    @Transactional
    @Override
    public void saveTeachplan(SaveTeachplanDto teachplanDto) {
        //课程计划id
        Long id = teachplanDto.getId();
        //修改课程计划
        if (id != null) {
            Teachplan teachplan = teachplanMapper.selectById(id);
            BeanUtils.copyProperties(teachplanDto, teachplan);
            teachplanMapper.updateById(teachplan);
        } else {
            //取出同父同级别的课程计划数量
            int count = getTeachplanCount(teachplanDto.getCourseId(), teachplanDto.getParentid());
            Teachplan teachplanNew = new Teachplan();
            //设置排序号
            teachplanNew.setOrderby(count + 1);
            BeanUtils.copyProperties(teachplanDto, teachplanNew);

            teachplanMapper.insert(teachplanNew);

        }
    }

    /**
     * @description 获取最新的排序号
     * @param courseId  课程id
     * @param parentId  父课程计划id
     * @return int 最新排序号
     * @author Costar
     * @date 2023年5月23日 15点33分
     */
    private int getTeachplanCount(long courseId,long parentId){
        LambdaQueryWrapper<Teachplan> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Teachplan::getCourseId,courseId);
        queryWrapper.eq(Teachplan::getParentid,parentId);
        Integer count = teachplanMapper.selectCount(queryWrapper);
        return count;
    }

    /**
     * 根据课程计划Id删除课程计划
     * @auther Costar
     * @param teachplanId  课程Id
     * @date 2023年5月23日 15点25分
     */
    @Override
    public void deleteTeachplanById(long teachplanId){
        Teachplan teachplan = teachplanMapper.selectById(teachplanId);

        //如果是章节点，如果章节点含有小结，则不能删除
        if (teachplan.getParentid() == 0 && getTeachplanCount(teachplan.getCourseId(), 0) != 0){
            throw new BaseException(120409, "课程计划信息还有子级信息，无法操作");
        } else {
            teachplanMapper.deleteById(teachplanId);
        }
    }

    /**
     * 根据课程计划Id移动
     * @auther Costar
     * @param teachplanId  课程Id
     * @date 2023年5月23日 14点06分
     */
    @Override
    public void moveup(long teachplanId){

    }

    /**
     * 根据课程计划Id移动
     * @auther Costar
     * @param teachplanId  课程Id
     * @date 2023年5月23日 14点06分
     */
    @Override
    public void movedown(long teachplanId){

    }


}
