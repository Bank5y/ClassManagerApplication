package Test;

import com.swpu.lihongye.utils.InputUtil;
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
