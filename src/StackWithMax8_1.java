import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithMax8_1 {
    //the general idea is to push/pop both valStack and maxStack. update max only if curr val is greater than maxStack.peek
    private Deque<Integer> valStack = new ArrayDeque<>(); //keeps the value
    private Deque<Integer> maxStack = new ArrayDeque<>(); //keeps the max

    public void push(int val) {
        if (valStack.isEmpty()) {
            valStack.push(val);
            maxStack.push(val);
            return;
        }

        valStack.push(val);
        if (maxStack.peek() > val) {
            maxStack.push(maxStack.peek());
        } else {
            maxStack.push(val); //val is greater than current max
        }
    }

    public Integer pop() {
        if (valStack.isEmpty()) {
            throw new IllegalArgumentException("stack is empty");
        }
        maxStack.pop();
        return valStack.pop();
    }

    public Integer getMax() {
        if (maxStack.isEmpty()) {
            return null;
        }
        return maxStack.pop();
    }

    public Integer peek() {
        if (valStack.isEmpty()) {
            throw new IllegalArgumentException("stack is empty");
        }
        return valStack.peek();
    }
}
