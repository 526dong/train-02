package dong.collection.map;

import java.util.HashMap;

/**
 * Created by user on 2017/9/18.
 */
public class TestThreadSecurity {
    public static final HashMap<String, String> firstHashMap = new HashMap<String, String>();

    public static void main(String[] args) throws InterruptedException {

        //�߳�һ
        for (int i = 0;i < 1000;i++) {
            new Thread(){
                public void run() {
                    for(int j = 0;j < 100;j++){
                        firstHashMap.put(String.valueOf(j), String.valueOf(j));
                    }
                }
            }.start();
        }


        /*//�̶߳�
        Thread t2 = new Thread(){
            public void run() {
                for(int j = 25;j < 50;j++){
                    firstHashMap.put(String.valueOf(j), String.valueOf(j));
                }
            }
        };*/

        /*t1.start();
        t2.start();*/

        //���߳�����1���ӣ��Ա�t1��t2�����߳̽�firstHashMap��װ��ϡ�
        Thread.currentThread().sleep(1000);

        for(int l = 0;l < 50;l++){
            //���key��value��ͬ��˵���������߳�put�Ĺ����г����쳣��
            if(!String.valueOf(l).equals(firstHashMap.get(String.valueOf(l)))){
                System.err.println(String.valueOf(l)+":"+firstHashMap.get(String.valueOf(l)));
            }
        }
    }
}
