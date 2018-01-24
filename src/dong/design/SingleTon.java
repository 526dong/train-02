package dong.design;

/**
 * @author Created by xzd on 2017/12/21.
 * @Description
 */
public class SingleTon {
    public static int STATUS = 1;

    private SingleTon() {
        System.out.println("SingleTon is create");
    }

    private static SingleTon instance = new SingleTon();
    public static SingleTon getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(SingleTon.STATUS);
    }
}
