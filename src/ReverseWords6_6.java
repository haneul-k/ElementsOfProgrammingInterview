import java.util.ArrayList;
import java.util.List;
public class ReverseWords6_6 {

    public static void reverseString(char[] inputStr, int start, int end) {
        while (start < end) {
            char temp = inputStr[start];
            inputStr[start] = inputStr[end];
            inputStr[end] = temp;
            start++;
            end--;
        }
    }

    public static void reverseWords(char[] inputStr) {
        reverseString(inputStr, 0, inputStr.length - 1);
        List<Integer> spaces = new ArrayList<>();
        for (int i = 0; i < inputStr.length; i++) {
            if (inputStr[i] == ' ') {
                spaces.add(i);
            }
        }

        int start = 0;
        for (Integer space : spaces) {
            reverseString(inputStr, start, space - 1);
            start = space + 1;
        }
        //deal with the last word
        reverseString(inputStr, start, inputStr.length - 1);
    }

    public static void main(String[] args) {
        String inputStr = "Bob likes Alice";
        char[] charArray = inputStr.toCharArray();
        reverseWords(charArray);
        System.out.println(String.copyValueOf(charArray));
    }
}

