package dong.design;

/**
 * @author Created by xzd on 2017/12/21.
 * @Description 懒汉式的单例模式
 */
public class LazySingleTon {
    private LazySingleTon(){
        System.out.println("LazySingleTon is create");
    }

    private static LazySingleTon instance = null;
    public static synchronized LazySingleTon getInstance(){
        if (instance == null) {
            instance = new LazySingleTon();
        }
        return instance;
    }
}
