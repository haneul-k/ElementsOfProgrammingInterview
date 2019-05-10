public class SnakeString6_11 {

    public static String snakeString(String inputStr) {
        //first line starts at index 1, with mod 4
        //second line starts at index 0, with mod 2
        //third line starts at index 3, with mod 4

        //  e               l
        //H   l   o   W   r   d
        //      l       o

        StringBuilder firstLine = new StringBuilder();
        StringBuilder secondLine = new StringBuilder();
        StringBuilder thirdLine = new StringBuilder();

        for (int i = 0; i < inputStr.length(); i++) {
            if (i % 4 == 1) { //
                firstLine.append(inputStr.charAt(i));
                firstLine.append(' ');
            } else {
                firstLine.append(' ');
                firstLine.append(' ');
            }
            if (i % 2 == 0) {
                secondLine.append(inputStr.charAt(i));
                secondLine.append(' ');
            } else {
                secondLine.append(' ');
                secondLine.append(' ');
            }
            if (i % 4 == 3) {
                thirdLine.append(inputStr.charAt(i));
                thirdLine.append(' ');
            } else {
                thirdLine.append(' ');
                thirdLine.append(' ');
            }
        }

        firstLine.append('\n');
        secondLine.append('\n');

        String res = firstLine.toString() + secondLine.toString() + thirdLine.toString();
        return res;
    }

    public static void main(String[] args) {
        String input = "Hello World!";
        System.out.println(snakeString(input));
    }
}
