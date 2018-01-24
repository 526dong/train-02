package dong.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xzd on 2017/9/28.
 */
public class SocketServerTest{
    private Socket socket;
    private ServerSocket ss;

    public SocketServerTest() throws IOException {
        ss = new ServerSocket(7777);
        while (true) {
            socket = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("you input is : " + br.readLine());
            /*System.out.println("连接成功");*/
        }
    }

    public static void main(String[] args) {
        try {
            new SocketServerTest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
