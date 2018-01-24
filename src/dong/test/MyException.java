package dong.test;

/**
 * Created by xzd on 2017/9/15.
 */
public class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
