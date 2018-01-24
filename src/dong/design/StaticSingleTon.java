package dong.design;

/**
 * @author Created by ${xzd} on 2017/12/21.
 * @Description
 */
public class StaticSingleTon {
    private StaticSingleTon() {
        System.out.println("StaticSingleTon is create");
    }

    private static class SingleTonHolder{
        private static StaticSingleTon instance = new StaticSingleTon();
    }

    public static StaticSingleTon getInstance(){
        return SingleTonHolder.instance;
    }


}
