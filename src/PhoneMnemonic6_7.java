import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneMnemonic6_7 {
    static Map<Character, String> map = new HashMap<>();
    static List<String> res = new ArrayList<>();

    public static List<String> phoneMnemonic(String phoneNumber) {
        map.put('2', "ABC");
        map.put('3', "DEF");
        map.put('4', "GHI");
        map.put('5', "JKL");
        map.put('6', "MNO");
        map.put('7', "PQRS");
        map.put('8', "TUV");
        map.put('9', "WXYZ");

        phoneMnemonicRecurse(phoneNumber, 0, 0, new StringBuilder());
        return res;
    }

    public static void phoneMnemonicRecurse(String phoneNumber, int numPointer, int alphPointer, StringBuilder currStr) {
        if (numPointer == phoneNumber.length()) {
            String finalStr = currStr.toString();
            res.add(finalStr);
            return;
        }
        char intVal = phoneNumber.charAt(numPointer);
        String alphStr = map.get(intVal);
        if (alphStr == null || alphStr.length() == alphPointer) {
            return;
        }

        char nextChar = alphStr.charAt(alphPointer);
        currStr.append(nextChar);

        phoneMnemonicRecurse(phoneNumber, numPointer + 1, 0, currStr);
        currStr.deleteCharAt(numPointer);
        phoneMnemonicRecurse(phoneNumber, numPointer, alphPointer + 1, currStr);

    }

    public static void main(String[] args) {
        String string = "239";
        List<String> res = phoneMnemonic(string);
        System.out.println(res.toString());

        String string1 = "231";
        List<String> res1 = phoneMnemonic(string1);
        System.out.println(res1.toString());
    }

}
