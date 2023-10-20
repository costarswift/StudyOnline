package com.xuecheng.content.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Project StudyOnline
 * @Package com.xuecheng.content.api
 * @Name FreemakerController
 * @Version 1.0
 * @Description freemaker测试
 * @Author Costar
 * @Date 2023-06-12 下午 2:14
 */

@Controller
public class FreemarkerController {
    @GetMapping("/testfreemarker")
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("name","FreeMarker");
        //设置模板名称
        modelAndView.setViewName("test");
        return modelAndView;
    }

}
