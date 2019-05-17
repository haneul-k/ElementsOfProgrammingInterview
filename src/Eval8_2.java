import java.util.LinkedList;
import java.util.Queue;

public class Eval8_2 {

    public static int eval(String RPNExpression) {
        Queue<String> queue = new LinkedList<>();
        String[] parseRPN = RPNExpression.split(",");
        for (String RPN : parseRPN) {
            queue.add(RPN);
        }
        int base = Integer.parseInt(queue.poll());
        int second = 0;

        while(!queue.isEmpty()) {
            second = Integer.parseInt(queue.poll());
            String expression = queue.poll();
            switch (expression) {
                case "+":
                    base += second;
                    break;
                case "*":
                    base *= second;
                    break;
                case "/":
                    base /= second;
                    break;
            }
        }
        return base;
    }

    public static void main(String[] args) {
        String string = "1279";
        String string1 = "3,4,+,2,*,1,+";
        String string2 = "1,1,+,-2,*";
        String string3 = "-641,6,/,28,/";

        System.out.println(eval(string));
        System.out.println(eval(string1));
        System.out.println(eval(string2));
        System.out.println(eval(string3));
    }
}
