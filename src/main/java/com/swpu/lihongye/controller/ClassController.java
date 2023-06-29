package com.swpu.lihongye.controller;

import com.swpu.lihongye.pojo.ClassMessage;
import com.swpu.lihongye.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class ClassController {



    @RequestMapping("/classes")
    public String getAllClasses(Model model) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassService classService=(ClassService) context.getBean("classService");
        List<ClassMessage> list=classService.getAllClass();
        model.addAttribute("classes", list); // ����ѯ������ݸ���ͼ
        return "class-list"; // ������ͼ����
    }
}
