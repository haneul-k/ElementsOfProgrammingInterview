import java.util.Arrays;

public class Queue8_7 {
    public int head, tail, size;
    public int[] queue;
    private final int SCALE_FACTOR = 2;

    public Queue8_7(int initialLength) {
        this.head = 0;
        this.tail = -1;
        this.size = 0;
        this.queue = new int[initialLength];
    }

    public void enqueue(int val) {
        if (size == queue.length) { //the queue is full so we need to rescale
            int[] newQueue = new int[queue.length * SCALE_FACTOR];
            int j = 0; //pointer to fill up newQueue

            int headVal = this.head;
            newQueue[j++] = queue[head];

            for (int i = head+1; i != headVal; i = (i+1)%queue.length) {
                newQueue[j++] = queue[i];
            }

            newQueue[j] = val; //enqueue new value

            this.head = 0;
            this.tail = j;
            size++;
            this.queue = newQueue;
        } else {
            this.tail = (tail + 1) % queue.length;
            this.queue[tail] = val;
            size++;
        }
    }

    public int dequeue() {
        if (size == 0) {
            throw new IllegalArgumentException("There is nothing to remove");
        }

        Integer headVal = queue[head];
        this.head = (head + 1) % queue.length;
        size--;
        return headVal;
    }

    public String toString() {
        return Arrays.toString(queue);
    }
}
