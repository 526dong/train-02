package dong.suanfa;

import java.util.Stack;

/**
 * @author Created by xzd on 2017/12/13.
 * @Description
 */
public class GetMainFromStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public GetMainFromStack(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum){
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum < this.getMin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin(){
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        GetMainFromStack getMain = new GetMainFromStack();

        for (int i = 0; i < 10; i++) {
            getMain.push(i);
        }

        System.out.println(getMain.getMin());
    }
}
