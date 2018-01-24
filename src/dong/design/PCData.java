package dong.design;

/**
 * @author Created by ${xzd} on 2017/12/21.
 * @Description
 */
public final class PCData {
    private final int intData;

    public PCData(int data){
        intData = data;
    }

    public PCData(String data){
        intData = Integer.valueOf(data);
    }

    public int getData(){
        return intData;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "intData=" + intData +
                '}';
    }
}
