package dong.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

/**
 * Created by xzd on 2017/9/28.
 */
public class SocketClientTest {
    private Socket client;
    private PrintWriter pw;
    public SocketClientTest() throws UnknownHostException, IOException {
        client = new Socket();
        //连接服务器
        client.connect(new InetSocketAddress("127.0.0.1",7777));
        pw = new PrintWriter(client.getOutputStream());
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));*/
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

        pw.println("我想连接你。。。");

        /*pw.write(br.readLine());*/
        pw.close();
        br.close();
    }
    public static void main(String[] args) {
        try {
            new SocketClientTest();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
