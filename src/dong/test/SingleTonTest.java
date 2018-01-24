package dong.test;

/**
 * Created by user on 2017/9/27.
 */

/**
 * ����ʽ
public class SingleTonTest {
    private static SingleTonTest instance = new SingleTonTest();

    public static SingleTonTest getInstance() {
        return instance;
    }
}*/

public class SingleTonTest {
    private static SingleTonTest instance = null;

    public static synchronized SingleTonTest getInstance(){
        if (instance == null) {
            instance = new SingleTonTest();
        }

        return instance;
    }

    public void test() {
        /*new Comparable<Integer, Integer>(){
            @Override
            public int compareTo(Integer i, Integer j) {
                return 1;
            }

        }*/
    }
}
