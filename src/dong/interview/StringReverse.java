package dong.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Created by xzd on 2017/12/4.
 * @Description 字符串反转
 */
public class StringReverse {
    public static void main(String[] args) {
        String str = "helloWorld";
        System.out.println(method1(str));
        System.out.println(method2(str));
        System.out.println(method3(str));
        System.out.println(method4(str));
    }

    /**
     * StringBuffer reverse method
     * @param str
     * @return
     */
    public static String method1(String str){
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        return sb.reverse().toString();
    }

    /**
     * 利用栈先进后出的特性将字符串反序
     * @param str
     * @return
     */
    public static String method2(String str){
        char[] chars = str.toCharArray();
        Stack<Character> myChar = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            myChar.push(chars[i]);
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < chars.length; i++) {
            sb.append(myChar.pop());
        }

        return sb.toString();
    }

    /**
     * 字串数组反序输出
     * @param str
     * @return
     */
    public static String method3(String str){
        char[] chars = str.toCharArray();

        StringBuffer sb = new StringBuffer();

        for (int i = chars.length-1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }

    public static String method4(String str){
        char[] chars = str.toCharArray();

        List<Character> list = new ArrayList<>();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i]);
        }

        Collections.reverse(list);

        System.out.println(list);

        for (Character c:list) {
            sb.append(c);
        }

        return sb.toString();
    }
}
