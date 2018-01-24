package dong.async.concurrent;

/**
 * @author Created by ${xzd} on 2018/1/7.
 * @Description
 */
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetData {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/yangqi/mem/1"));
        String line;
        Map<String, List<String>> result = new HashMap<String, List<String>>();
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");

            String key = data[3];
            String value = data[2];

            List<String> list = result.get(key);
            if (list == null) {
                list = new ArrayList<String>();
            }
            list.add(value);
            result.put(key, list);
        }
        reader.close();

        List<List<String>> allList = new ArrayList<List<String>>();

        result.forEach((k, v) -> {
            allList.add(v);
        });


        BufferedWriter writer = new BufferedWriter(new FileWriter("/tmp/ok"));
        result.forEach((k, v) -> {
            if (k.equals("java.util.regex.Matcher")) {
                System.out.println(v);
            }
            String bytesize = v.get(0);
            if (Long.valueOf(bytesize) > 1000000) {
                System.out.println(k + "|" + v.toString());
                StringBuilder sb = new StringBuilder();
                sb.append(k).append(",");
                v.forEach((str) -> {
                    sb.append(str).append(",");
                });

                try {
                    writer.write(sb.append("\n").toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        writer.close();


        System.out.println(result.size());
        System.out.println(allList.size());

        for (int i = 0; i < 10; i++) {
            //    System.out.println(allList.get(i));
        }
    }
}
