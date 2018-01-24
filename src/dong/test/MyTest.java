package dong.test;

/**
 * @author Created by xzd on 2017/11/28.
 * @Description
 */
public class MyTest {
    public static void main(String[] args) {
        int test = test();
        System.out.println(test);
    }

    public static int test(){
        int i = 1;

        try {
            i = 2;
            return i;
        } catch (Exception e) {
            i = 3;
            return i;
        } finally {
            i = 4;
        }
    }
}
