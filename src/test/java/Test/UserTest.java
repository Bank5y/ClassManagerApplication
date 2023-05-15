package Test;

import com.swpu.lihongye.dao.UserMapper;
import com.swpu.lihongye.pojo.Class;
import com.swpu.lihongye.pojo.Teacher;
import com.swpu.lihongye.utils.InputUtil;
import com.swpu.lihongye.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Scanner;
import java.util.function.Consumer;

public class UserTest {
    @Test
    public void userFindByIdTest() {
        Scanner scanner=new Scanner(System.in);
        char m= InputUtil.getCharInput(scanner);
        System.out.println(m);
    }
}
