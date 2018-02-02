package dong.myutils;

import dong.test.User;
import org.junit.Test;

import java.io.*;
import java.text.Collator;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Created by xzd on 2017/11/27.
 * @Description Ҫ����һ���õ�ϰ�ߣ�������Ԫ���ԣ�ʹ�Լ��ķ�������ǿ׳�ͽ�׳
 */
public class MyUtils {
    public static void main(String[] args) {
        String code = replaceCode("\"dsfs\"");
        System.out.println(code);
    }

    public void testThread(){
        //���̲߳����ж�����ģʽ
        //Futureģʽ
    }

    public void test(){

    }


    @Test
    public void testUUid(){
        System.out.println(new Random().nextFloat()*90);
        System.out.println(new Random().nextFloat()*90);
        System.out.println(new Random().nextFloat()*90);
        System.out.println(new Random().nextFloat()*90);
        System.out.println(new Random().nextFloat()*90);
        System.out.println(new Random().nextFloat()*90);
    }

    @Test
    public void testArrayCopy(){
        int[] arr = {1, 3, 4, 5, 7};
        int[] ints = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    @Test
    public void testFastFail(){
        List<Integer> list = new ArrayList<>(20);

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < list.size(); i++) {
                        if (i/2 == 0) {
                            Thread.sleep(1000);
                        }
                        System.out.println(list.get(i));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                list.remove(10);
            }
        }).start();



        Thread t1 = new Thread("dong-train01");
        Thread t2 = new Thread("dong-train02");
        t1.start();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    @Test
    public void testArraySort() {
        String[] strArrays = new String[]{"liming01", "liming02", "liming11", "mayun", "haha"};
        Arrays.sort(strArrays, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < strArrays.length; i++) {
            System.out.println(i+":"+strArrays[i]);
        }
    }

    @Test
    public void testAtomicIntegerGet(){
        AtomicInteger count = new AtomicInteger();
        int i1 = count.incrementAndGet();
        System.out.println(i1);
    }

    @Test
    public void testDemo(){
        String test = "a,b,c,d,e,f,,,my";

        //csv��txt split
        String[] columnArr = test.split(",");

        //���һλΪ�մ���
        if (columnArr.length < 9) {
            test = test+"mycode";
            columnArr = test.split(",");
        }


        System.out.println(columnArr.length);

        for (int i = 0; i < columnArr.length; i++) {
            System.out.println(columnArr[i]);
        }

        /*String str1 = ",,,,,,AAAaaa";
        String str2 = "AAAaaa,,,,,";

        String[] split = str2.split(",");
        System.out.println(split.length);
        for (int i = 0; i < split.length; i++) {
            System.out.println("�����"+split[i]);
        }*/

        /*String s = str.replaceAll("[^ABC]", "");
        System.out.println(s+":111111");*/
    }

    @Test
    /**
     * add�����ڶ�����ʱ����������������Ԫ��ʱ����ֱ���׳��쳣-IllegalStateException/queue full-��ʾ�����Ѿ�����
     * add�����ײ���õľ���offer���������Ԫ��ʱ�������true������ӳɹ�/�������false���׳��쳣queue full
     */
    public void testQueueAddMethod(){
        try {
            LinkedBlockingQueue<String> queue = new LinkedBlockingQueue(2);

            queue.add("hello");
            queue.add("world");
            queue.add("yes");
        } catch (Exception e) {
            if (e instanceof IllegalStateException) {
                System.out.println("�����߽�"+e.getMessage());
            }
            e.printStackTrace();
        }
    }

    @Test
    /**
     * put�����ڶ�����ʱ����������������ᱨ��
     */
    public void testQueuePutMethod(){
        try {
            LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(2);

            queue.put("hello");
            queue.put("world");
            queue.put("yes");
            System.out.println("hello boy");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    /**
     * offer�����ڶ�����ʱ���������Ԫ�ػ᷵��false
     */
    public void testQueueOfferMethod(){
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(2);

        boolean hello = queue.offer("hello");
        boolean world = queue.offer("world");
        boolean yes = queue.offer("yes");
        System.out.println(queue.toString());
        System.out.println(hello);
        System.out.println(world);
        System.out.println(yes);
    }

    @Test
    public void testSplit1(){
        String test = "/ccx-abs//asset/findAll";
        if (test.contains("//")) {
            String replace = test.replace("//", "/");
            System.out.println(replace);
        }

    }

    /*public void put(E e) throws InterruptedException {
        checkNotNull(e);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == items.length)
                notFull.await();
            enqueue(e);
        } finally {
            lock.unlock();
        }
    }

    public boolean offer(E e) {
        checkNotNull(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (count == items.length)
                return false;
            else {
                enqueue(e);
                return true;
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean offer(E e, long timeout, TimeUnit unit)
            throws InterruptedException {

        checkNotNull(e);
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == items.length) {
                if (nanos <= 0)
                    return false;
                nanos = notFull.awaitNanos(nanos);
            }
            enqueue(e);
            return true;
        } finally {
            lock.unlock();
        }
    }*/

    @Test
    public void testUnsafe(){
        Class clazz = MyUtils.class;
        System.out.println(clazz.getClassLoader());
    }

    @Test
    public void testLinked() {
        List<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

    }

    @Test
    public void testHashMap(){
        Map<Integer, Integer> map = new ConcurrentHashMap<>();

        for (int i = 1; i <= 100; i++) {
            map.put(i, i*2);
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();

            System.out.println(next.getKey()+"|"+next.getValue());
        }
    }

    /**
     * Ҫд�����ܽ�׳�Ĵ���
     */
    @Test
    public void testSkipMap(){
        Map<Integer, Integer> map = new ConcurrentSkipListMap<>();

        for (int i = 1; i <= 100; i++) {
            map.put(i, i*2);
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();

            System.out.println(next.getKey()+"|"+next.getValue());
        }
    }

    @Test
    public void testListSort(){
        /*List<Integer> list = new ArrayList();

        list.add(7);
        list.add(12);
        list.add(31);
        list.add(4);
        list.add(94);
        list.add(15);

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/

        List<User> userList = new ArrayList<>();

        userList.add(new User("1", "22", "liming", 1));
        userList.add(new User("2", "27", "liuli", 3));
        userList.add(new User("3", "20", "haha", 4));
        userList.add(new User("1", "22", "lala", 1));
        userList.add(new User("5", "23", "xixi", 4));

        final boolean isRight = false;

        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                Integer degree1 = o1.getDegree();
                Integer degree2 = o2.getDegree();
                String name1 = o1.getName();
                String name2 = o2.getName();

                if (degree1.equals(degree2)) {
                    String[] nameArray = new String[2];
                    nameArray[0] = name1;
                    nameArray[1] = name2;

                    //��������
                    String entName = sortEntName(nameArray);

                    return (entName.equals(name1)) ? -1 : 1;
                } else {
                    return isRight ? (degree1.intValue() - degree2.intValue()) : (degree2.intValue() - degree1.intValue());
                }
            }
        });

        for (User user:userList) {
            System.out.println(user.getId()+"|"+user.getName()+"|"+user.getAge()+"|"+user.getDegree());
        }
    }

    @Test
    public void testTab(){
        /*String str = "contract_id\tapply_dts\tapply_amount\tapply_month\tlogin_origin\tmobile_company\tnet_age\treapply_cnt";
        System.out.println(str.contains("\t"));*/

        //String test = "hello    world   i   am  struggle    teen";
        String val = "29586\t297\t2000\t3\t1\t2\t\t2\t0\t1\t1\tsdzj\t\t27\t2\t182\t35\t1\t2307477\t73\t2\t2\t1\t1\t1\t1\t0\t3\t1\t2\t1\t0\t6\t18";

        /*String splitCode = "\t";*/

        /*String splitCode = "�Ʊ��";
        String splitReg = "";
        if ("����".equals(splitCode)) {
            splitReg = ",";
        } else if ("�Ʊ��".equals(splitCode)) {
            splitReg = "\t";
        } else {
            splitReg = splitCode;
        }

        Pattern p = Pattern.compile("\\s*|"+splitReg);
        Matcher m = p.matcher(test);

        System.out.println(m.find());*/

        //String[] split = test.split(splitReg);
        String[] split = val.split("\t");

        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }


        /*boolean matches = m.matches();

        System.out.println(matches);*/

        //if (test.contains(splitCode)) {
            /*String[] split = test.split(splitCode);
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[i]);
            }*/
        //}
    }

    public void getHtml(){

    }

    @Test
    public void testSplit(){
        String str = "104,2,3::�ļ��������Ʋ����Ϲ淶";

        String[] arr = str.split("::");
        System.out.println(arr);
    }

    @Test
    public void testSort(){
        Comparator cmp = Collator.getInstance(java.util.Locale.CHINA);

        String[] arr = { "����", "����", "����", "����" ,"�ܝ�","����","����"};
        String[] arr1 = {"sdf","sdfdsf","ewrewr","wer","ert","rtytre","erturt","rty", "1", "2", "����", "����"};

        Arrays.sort(arr1, cmp);

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

    }

    /**
     * ��ҵ��������
     * @param nameArray ��ҵ���Ƽ���
     * @return
     */
    public String sortEntName(String[] nameArray){
        //���ñȽ�����ʽ
        Comparator cmp = Collator.getInstance(java.util.Locale.CHINA);
        Arrays.sort(nameArray, cmp);

        return nameArray[0];
    }

    @Test
    public void testListSize(){
        int a = 520;
        int b = 520;
        System.out.println(a == b);
    }

    /**
     * ���ַ����е�˫������Ϊ��
     * @param code
     * @return
     */
    public static String replaceCode(String code){
        String replaceCode = code.replace("\"","");
        return replaceCode;
    }

    /**
     * �ж��ļ��ı����ʽ
     * @param filePath
     * @return �ļ������ʽ
     */
    public static String judgeFileEncode(String filePath) {
        FileInputStream fis = null;
        BufferedInputStream bis = null;

        try {
           fis = new FileInputStream(new File(filePath));
           bis = new BufferedInputStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int p = 0;
        try {
            p = (bis.read() << 8) + bis.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                bis.close();
                fis = null;
                bis = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String code = null;
        if (p != 0) {
            //���е� 0xefbb��0xfffe��0xfeff��0x5c75��Щ��������ļ���ǰ�������ֽڵ�16������
            switch (p) {
                case 0xefbb:
                    code = "UTF-8";
                    break;
                case 0xfffe:
                    code = "Unicode";
                    break;
                case 0xfeff:
                    code = "UTF-16BE";
                    break;
                case 0x5c75:
                    code = "ANSI|ASCII" ;
                    break ;
                default:
                    code = "GBK";
            }
        }

        return code;
    }

    /**
     * �Ƿ�Ϊʵ��
     * @param param
     * @return
     */
    public static boolean isDecimal(String param){
        return isMatch("0|^[+-]?\\d+(\\.\\d+)?$", param);
    }

    public static boolean isTabCode(String param){return isMatch("\\s*|\\t", param);}

    /**
     * �����ж��Ƿ�Ϊ������С��
     * @param regex
     * @param param
     * @return
     */
    private static boolean isMatch(String regex, String param){
        if (param == null || param.trim().equals("")) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher isNum = pattern.matcher(param);

        return isNum.matches();
    }


}
