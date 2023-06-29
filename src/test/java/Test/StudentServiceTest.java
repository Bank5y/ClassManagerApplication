package Test;


import com.swpu.lihongye.pojo.ClassMessage;
import com.swpu.lihongye.pojo.StudentMessage;
import com.swpu.lihongye.service.ClassService;
import com.swpu.lihongye.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentServiceTest {
    @Test
    public void userServiceTest(){
    ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassService classService=(ClassService) context.getBean("classService");
        List<ClassMessage> list=classService.getAllClass();
        list.forEach(System.out::println);
    }
}
