package dong.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Created by xzd on 2017/11/16.
 * @Description
 */
public class MyPageTest {
    private static List<Integer> list = new ArrayList<>();

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        getArrayList();

        long start = System.currentTimeMillis();

        dealList();
        /*System.out.println(map);*/

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    /**
     * 获取list集合
     * @return
     */
    public static void getArrayList(){
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
    }

    public static void dealList(){
        //分批处理
        if(null != list && list.size()>0){
            int pointsDataLimit = 1000;//限制条数
            Integer size = list.size();
            //判断是否有必要分批
            if(pointsDataLimit < size){
                int part = size/pointsDataLimit;//分批数
                System.out.println("共有 ： "+size+"条，！"+" 分为 ："+part+"批");

                for (int i = 0; i < part; i++) {
                    //1000条
                    List<Integer> listPage = list.subList(0, pointsDataLimit);
                    System.out.println(listPage);
                    //剔除
                    list.subList(0, pointsDataLimit).clear();
                }

                if(!list.isEmpty()){
                    System.out.println(list);//表示最后剩下的数据
                }
            }else{
                System.out.println(list);
            }
        }else{
            System.out.println("没有数据!!!");
        }
    }

    /**
     * 批量分析list集合
     * @param pageNo
     *//*
    public static void batchAnalysisList(Integer pageNo){
        MyPage<Integer> myPage = new MyPage<>();

        myPage.setPageNo(pageNo);
        myPage.setPageSize(11);

        myPage.setRows(list);

        List<Integer> rows = myPage.getRows();

        for (int i = 0; i < rows.size(); i++) {
            map.put(rows.get(i), 1);
        }

        if (myPage.getPageNo() < myPage.getTotalPageNo()) {
            batchAnalysisList(++pageNo);
        }
    }*/

}
