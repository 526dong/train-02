package dong.collection.array;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 2017/9/15.
 */
public class ArrayUtils {
    public static void main(String[] args) {

        BigDecimal bg = new BigDecimal("0.0040");

//        System.out.println(bg.divide(new BigDecimal("13"), 6, BigDecimal.ROUND_HALF_DOWN));

        System.out.println(bg.scale());
        System.out.println(new BigDecimal("0.234").scale());
        System.out.println(new BigDecimal(0.2).scale());

        BigDecimal multiply = bg.multiply(new BigDecimal(0.234));
        System.out.println(multiply.scale());

        System.out.println(multiply+":"+multiply.toPlainString().length());

        /*//html url
        String htmlUrl = "d:/data/model/maxiaoyang/detailVarhtml.html";

        //文件名称
        String fileName = htmlUrl.substring(htmlUrl.lastIndexOf("/")+1);
        System.out.println(fileName);*/

        /*String str = ",,,1,2,3,4,5,6,,,,,7";

        String[] split = str.split(",");

        //System.out.println(split.length);

        if (split.length == 14) {
            for (int i = 0; i < 14; i++) {
                System.out.println(split[i]);
            }
        } else {
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[i]+"lala");
            }
        }*/

        /*
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(2);

        boolean flag = true;

        for (int i = 0; i < list.size(); i++) {
            Integer columnValue = list.get(i);

            if (!"0".equals(columnValue) && !"1".equals(columnValue)) {
                flag = false;
            }
        }

        System.out.println(flag);*/


        /*String fileName = "abs.xml";

        System.out.println(fileName.substring(0, fileName.indexOf(".")));*/

        /*System.out.println(allNumber("-0.41"));*/

        /*System.out.println(isPositiveDecimal("10.0025056337811100"));*/

        /*boolean positiveDecimal = isMatchColumnName("_1");
        System.out.println(positiveDecimal);*/

        /*String splitCode = "，";
        char code = splitCode.charAt(0);

        boolean chinese = isChinese(code);
        System.out.println(chinese);*/

        /*Map<String, Object> map = new HashMap<>();

        map.put("name", "lala");
        map.put("age", "22");

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Object> entry = iterator.next();

            String key = entry.getKey();
            Object value = entry.getValue();

            System.out.println(value);

            System.out.println("key:"+key+"|value:"+value);
        }*/

        /*List<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(22);

        list.set(0, 1);

        System.out.println(list);*/

        /*String test = "123456781234";
        String creditCodeReg = "^[A-Za-z0-9]{18}$";
        String certificateCodeReg = "^[a-zA-Z\\d]{8}\\-[a-zA-Z\\d]$";
        final String orgCodeReg = "^\\d{12}$";

        Pattern compile = Pattern.compile(orgCodeReg);

        Matcher matcher = compile.matcher(test);

        System.out.println(matcher.matches());*/

        /*BigDecimal bd = new BigDecimal("20");

        BigDecimal divide = bd.divide(new BigDecimal("3"), 3, BigDecimal.ROUND_UP);

        System.out.println(divide);*/


        /*String[] oldArray = {"hello", "world", "able"};

        Arrays.sort(oldArray);

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < oldArray.length; i++) {
            sb.append(oldArray[i] + ",");
        }

        System.out.println(sb.substring(0, sb.length()-1));*/

        /*try {
            oldArray[2] = "hi" ;
        } catch (IndexOutOfBoundsException e) {
            oldArray = expandCapacity(oldArray);
            oldArray[2] = "hi" ;
            e.printStackTrace();
        }

        for (int i = 0; i < oldArray.length; i++) {
            System.out.println(oldArray[i]);
        }*/

        /*String[] newArray = expandCapacity(oldArray);
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }
        System.out.println(newArray);
        System.out.println(newArray.length);*/
    }

    /**
     * 是否是中文
     * GENERAL_PUNCTUATION 判断中文的"号
     * CJK_SYMBOLS_AND_PUNCTUATION 判断中文的。号
     * HALFWIDTH_AND_FULLWIDTH_FORMS 判断中文的，号
     * @param c
     * @return
     */

    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);

        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }

        return false;
    }

    public static boolean isChinese(String str){
        String regEx = "[\\u4e00-\\u9fa5]+";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if(m.find()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isMatchColumnName(String param){
        return isMatch("^[A-Za-z_][A-Za-z_0-9]{0,50}$", param);
    }

    public static boolean isPositiveDecimal(String orginal){
        return isMatch("0", orginal) || isMatch("^\\+{0,1}[1-9]\\d*", orginal) || isMatch("\\+{0,1}[0]\\.[0-9]*|\\+{0,1}[1-9]\\d*\\.\\d*", orginal);
    }

    public static boolean allNumber(String param) {
        return isMatch("0|^[+-]?\\d+(\\.\\d+)?$", param);
    }

    private static boolean isMatch(String regex, String orginal){
        if (orginal == null || orginal.trim().equals("")) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher isNum = pattern.matcher(orginal);
        return isNum.matches();
    }

    public static <T> T[] compareValue(T[] datas){
        return datas;
    }

    /**
     * @desc �������������
     * @author chenssy
     * @data 2013-12-8
     * @param <T>
     * @param datas ԭʼ����
     * @param newLen ���ݴ�С
     * @return T[]
     */
    public static <T> T[] expandCapacity(T[] datas, int newLen){
        newLen = newLen < 0 ? datas.length :datas.length + newLen;
        //����һ���µ�����
        return Arrays.copyOf(datas, newLen);
    }

    /**
     * @desc ������������ݴ���1.5��
     * @author chenssy
     * @data 2013-12-8
     * @param <T>
     * @param datas  ԭʼ����
     * @return T[]
     */
    public static <T> T[] expandCapacity(T[] datas){
        int newLen = datas.length + (datas.length >> 1);      //����ԭʼ�����1.5��
        //����һ���µ�����
        return Arrays.copyOf(datas, newLen);
    }

    /**
     * @desc ������������ݴ���
     * @author chenssy
     * @data 2013-12-8
     * @param <T>
     * @param datas ԭʼ����
     * @param mulitiple ���ݵı���
     * @return T[]
     */
    public static <T> T[] expandCapacityMul(T[] datas, int mulitiple){
        mulitiple = mulitiple < 0 ? 1 : mulitiple;
        int newLen = datas.length * mulitiple;
        return Arrays.copyOf(datas,newLen );
    }
}
