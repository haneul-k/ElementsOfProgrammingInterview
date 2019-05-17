public class Queue8_7 {
    private int head, tail, size;
    private Integer[] queue;
    private final int SCALE_FACTOR = 2;

    public Queue8_7(int initSize) {
        head = 0;
        tail = -1;
        size = 0;
        this.queue = new Integer[initSize];
    }

}
