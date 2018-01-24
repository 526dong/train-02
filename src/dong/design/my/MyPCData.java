package dong.design.my;

/**
 * @author Created by ${xzd} on 2017/12/23.
 * @Description
 */
public class MyPCData {
    private int pcData;

    public MyPCData(int pcData) {
        this.pcData = pcData;
    }

    public Integer getPCData(){
        return pcData;
    }

    @Override
    public String toString() {
        return "MyPCData{" +
                "pcData=" + pcData +
                '}';
    }
}
