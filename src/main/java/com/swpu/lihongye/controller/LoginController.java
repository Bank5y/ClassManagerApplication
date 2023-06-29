package com.swpu.lihongye.controller;

import com.swpu.lihongye.dao.mapper.StudentMapper;
import com.swpu.lihongye.dao.mapper.StudentMessageMapper;
import com.swpu.lihongye.pojo.Student;
import com.swpu.lihongye.pojo.StudentMessage;
import com.swpu.lihongye.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    private final StudentMessageMapper studentMessageMapper=MybatisUtils.getSqlSession().getMapper(StudentMessageMapper.class);

    // Existing code for login method

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String showSuccessPage(Model model) {
        List<StudentMessage> students = studentMessageMapper.getAllStudents();
        model.addAttribute("students", students);
        return "success";
    }



    @RequestMapping(value = "/selected", method = RequestMethod.POST)
    public String showSelectedStudents(@RequestParam("selectedStudents") List<Long> selectedStudents,
                                       Model model) {
        List<StudentMessage> selectedStudentsList = new ArrayList<>();

        for (Long studentId : selectedStudents) {
            StudentMessage student = studentMessageMapper.selectByPrimaryKey(studentId);
            if (student != null) {
                selectedStudentsList.add(student);
            }
        }

        model.addAttribute("selectedStudents", selectedStudentsList);
        return "selected";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RedirectView login(@RequestParam("username") String username,
                              @RequestParam("password") String password, Model model) {
        if (username.equals("zhangsan") && password.equals("123")) {
            model.addAttribute("username", username);
            return new RedirectView("/success");
        } else {
            model.addAttribute("username", username);
            return new RedirectView("/login");
        }
    }
}
