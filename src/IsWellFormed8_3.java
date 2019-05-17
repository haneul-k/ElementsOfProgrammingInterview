import java.util.ArrayDeque;
import java.util.Deque;

public class IsWellFormed8_3 {

    public static boolean isWellFormed(String parentheses) {
        Deque<Character> leftParens = new ArrayDeque<>(); //stack to keep left parts of parenthesis

        for (Character paren : parentheses.toCharArray()) {
            if (paren == '[' || paren == '{' || paren == '(') { //is left part
                leftParens.push(paren);
            } else { //is right part
                if (leftParens.isEmpty()) {
                    return false;
                }
                Character parenToBeMatched = leftParens.pop();
                switch (paren) {
                    case ']':
                        if (parenToBeMatched != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (parenToBeMatched != '{') {
                            return false;
                        }
                        break;
                    case ')':
                        if (parenToBeMatched != '(') {
                            return false;
                        }
                        break;
                }
            }
        }
        return leftParens.isEmpty();
    }

    public static void main(String[] args) {
        String first = "[()[]{()()}]";
        String second = "[()[]{()()}]";
        String third = "[](({})";
        System.out.println(isWellFormed(first));
        System.out.println(isWellFormed(second));
        System.out.println(isWellFormed(third));
    }
}
