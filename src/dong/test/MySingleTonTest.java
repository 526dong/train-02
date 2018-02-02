package dong.test;

/**
 * @author Created by ${xzd} on 2018/1/24.
 * @Description
 */
public class MySingleTonTest {
    private static volatile MySingleTonTest instance;

    private static class MyInstance{
        public MyInstance(){

        }
    }

    public static MySingleTonTest getInstance(){
        if (instance != null) {
            synchronized (instance) {
                if (instance != null) {
                    instance = new MySingleTonTest();
                }
            }
        }
        return instance;
    }
}
