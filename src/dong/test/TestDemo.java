package dong.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by ${xzd} on 2017/11/9.
 * @Description
 * @return
 * @throws
 */
public class TestDemo {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("##.##");

        User user = new User();

        user.setId("0.1234");
        user.setAge("0.0134");
        user.setName("0.0025");

        try {
            Class<?> clazz = Class.forName("dong.test.User");

            Map<Integer, String> dataMap = getDataMap();

            for (int i = 0; i < dataMap.size(); i++) {
                Method getMethod = clazz.getDeclaredMethod("get" + dataMap.get(i));

                Object getValue = getMethod.invoke(user);

                Method setMethod = clazz.getDeclaredMethod("set" + dataMap.get(i), String.class);

                setMethod.invoke(user, df.format(new BigDecimal(Double.valueOf(String.valueOf(getValue)))));
            }

            System.out.println("id:"+user.getId()+"|age:"+user.getAge()+"|name:"+user.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        getDataMap();
    }

    /**
     * @return map
     */
    public static Map<Integer, String> getDataMap() {
        //priceDataMap put value
        Map<Integer, String> dataMap = new HashMap<>(3);

        dataMap.put(0, "Id");
        dataMap.put(1, "Age");
        dataMap.put(2, "Name");

        return dataMap;
    }
}
