import java.util.HashMap;
import java.util.Map;

public class IsLetterConstructibleFromMagazine12_2 {

    public static boolean isLetterConstructibleFromMagazine(String letterText, String magazineText) {
        Map<Character, Integer> map = new HashMap<>(); //<character, number of times appeared>

        //add characters from magazine to map
        for (char character : magazineText.toCharArray()) {
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1); //increment the number of appearance
            } else {
                map.put(character, 1); //first time appeared = 1
            }
        }

        for (char character : letterText.toCharArray()) {
            if (!map.containsKey(character)) {
                return false;
            }
            int appearance = map.get(character);
            if (appearance == 1) { //last appearance, so no more of the character left
                map.remove(character);
            } else {
                map.put(character, appearance - 1); //decrement the number of appearance
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String letter = "hello";
        String magazine = "olleqdnhh";
        String magazineTwo = "hhheelooo";

        System.out.println(isLetterConstructibleFromMagazine(letter, magazine));
        System.out.println(isLetterConstructibleFromMagazine(letter, magazineTwo));
    }
}
