import java.util.HashMap;
import java.util.Map;

public class RomanToInteger6_9 {

    public static int romanToInteger(String roman) {
        Map<Character, Integer> map = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int romanToNum = 0;
        if (roman == null || roman.length() == 0) {
            return romanToNum;
        }

        romanToNum += map.get(roman.charAt(0));
        for (int i = 1; i < roman.length(); i++) {
            char currChar = roman.charAt(i);
            char prevChar = roman.charAt(i-1);

            if (isException(prevChar, currChar)) {
                romanToNum -= map.get(prevChar);
                romanToNum += (map.get(currChar) - map.get(prevChar));
            } else {
                romanToNum += map.get(currChar);
            }
        }

        return romanToNum;
    }

    public static boolean isException(char a, char b) {
        if (a == 'I') {
            if (b == 'V' || b == 'X') {
                return true;
            }
            return false;
        }
        if (a == 'X') {
            if (b == 'L' || b == 'C') {
                return true;
            }
            return false;
        }
        if (a == 'C') {
            if (b == 'D' || b == 'M') {
                return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        String roman = "IVCCCM";
        System.out.println(romanToInteger(roman));
    }
}
