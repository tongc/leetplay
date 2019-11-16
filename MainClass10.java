import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;

public class MainClass10 {
    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        if (!s.contains(".") && !s.contains("*") && !p.contains(".") && !p.contains("*")) {
            return false;
        }
        int length = p.length();
        if (s.length() > p.length()) {
            length = s.length();
        }
        LinkedList<Character> first = new LinkedList(s.chars().mapToObj(c -> (char)c).collect(Collectors.toList()));
        LinkedList<Character> second = new LinkedList(p.chars().mapToObj(c -> (char)c).collect(Collectors.toList()));
        Character firstStarContinue = null;
        Character firstDotContinue = null;
        Character secondStarContinue = null;
        Character secondDotContinue = null;
        Character firstPreviousChar = null;
        Character secondPreviousChar = null;
        for (int i = 0; i < length; i++) {
            if(first.peek() == null && second.peek() != null) {
                if(second.peek()=='*') {
                    return true;
                } else {
                    return false;
                }
            }
            if(first.peek() != null && second.peek() == null) {
                if(first.peek()=='*') {
                    return true;
                } else {
                    return false;
                }
            }

            Character firstChar = first.pop();
            Character secondChar = second.pop();

            if(firstChar == '*') {
                if(!Objects.equals(secondChar, firstPreviousChar)) {
                    return false;
                }
            }
            if(secondChar == '*') {
                if(!Objects.equals(firstChar, secondPreviousChar)) {
                    return false;
                }
            }
            if(firstChar != '.' && secondChar != '.') {
                if(!Objects.equals(firstChar, secondChar)) {
                    return false;
                }
            }

            firstPreviousChar = firstChar;
            secondPreviousChar = secondChar;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MainClass10().isMatch("a", "b"));
        System.out.println(new MainClass10().isMatch("a", "a"));
        System.out.println(new MainClass10().isMatch("aa", "aa*"));
        System.out.println(new MainClass10().isMatch("aab", "aa."));
        System.out.println(new MainClass10().isMatch("aab", "aa*."));
    }
}
