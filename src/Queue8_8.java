import java.util.ArrayDeque;
import java.util.Deque;

public class Queue8_8 {
    //implementing a queue using stack
    Deque<Integer> enqueueStack = new ArrayDeque<>();
    Deque<Integer> dequeueStack = new ArrayDeque<>();

    public void enqueue(int val) {
        enqueueStack.push(val);
    }

    public int dequeue() {
        if (dequeueStack.isEmpty()) {
            //move everything from enqueueStack to dequeueStack
            if (enqueueStack.isEmpty()) {
                throw new IllegalArgumentException("there is nothing to dequeue");
            }
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.poll();
    }
}
