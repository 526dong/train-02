package dong.thread;

/**
 * @author Created by xzd on 2017/12/11.
 * @Description 线程的基本操作（二）终止线程
 * stop方法 立即停止线程，可能会产生数据不一致问题。该方法已经不推荐使用了。
 */
public class StopThread {
    public static User user = new User();

    public static class User{
        private int id;
        private String name;

        public User(){
            id = 0;
            name = "0";
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ChangeObjectThread extends Thread {
        volatile boolean stopme = false;

        public void stopMe() {
            stopme = true;
        }

        @Override
        public void run() {
            while (true) {
                if (stopme) {
                    System.out.println("exit");
                    break;
                }

                synchronized (user) {
                    int val = (int)(System.currentTimeMillis()/1000);
                    user.setId(val);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    user.setName(String.valueOf(val));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    if (user.getId() != Integer.parseInt(user.getName())) {
                        System.out.println(user.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        while (true) {
            Thread t = new ChangeObjectThread();
            t.start();
            Thread.sleep(150);
//            t.stop();

        }
    }
}
