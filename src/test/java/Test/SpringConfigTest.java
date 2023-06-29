package Test;



import com.swpu.lihongye.dao.mapper.StudentMapper;
import com.swpu.lihongye.pojo.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class SpringConfigTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testMapper() {
        List<Student> students = studentMapper.searchStu(null,null);
        Assert.assertNotNull(students);
    }
}
