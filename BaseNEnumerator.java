import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BaseNEnumerator {
    static char[] first = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
    static char[] second = new char[]{'1', '2', '3', '4', '5', '6'};
    static char[] third = new char[]{'a', 'b', 'd', 'e', 'g', 'z'};
    static char[] fourth = new char[]{'a', 'b', 'd', 'f', 'g', 'z'};
    static char[] fifth = new char[]{'a', 'k', 'e', 'h', 'g', 'z'};

    public List<List<Integer>> enumerator(int baseSize, int numOfDigits) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int i = 0; i < numOfDigits; i++) {
            results.get(0).add(0);
        }
        while (results.size() < Math.pow(baseSize, numOfDigits)) {
            results.add(nextNum(results.get(results.size() - 1), baseSize));
        }
        return results;
    }

    public List<Integer> nextNum(List<Integer> currentNumber, int baseSize) {
        List<Integer> next = new ArrayList<>(currentNumber);
        for (int i = 0; i < next.size(); i++) {
            if (next.get(i) < baseSize - 1) {
                next.set(i, next.get(i) + 1);
                break;
            } else {
                if(i<=next.size()-1) {
                    next.set(i, 0);
                } else {
                    break;
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new BaseNEnumerator().enumerator(6, 6));
        List<Integer> num = new ArrayList<>();
        num.add(5);
        num.add(5);
        num.add(5);
        System.out.println(new BaseNEnumerator().nextNum(num, 6));

        List<List<Integer>> enumerated = new BaseNEnumerator().enumerator(6, 5);
        for (int i = 0; i < enumerated.size(); i++) {
            char letter1 = first[enumerated.get(i).get(0)];
            char letter2 = second[enumerated.get(i).get(1)];
            char letter3 = third[enumerated.get(i).get(2)];
            char letter4 = fourth[enumerated.get(i).get(3)];
            char letter5 = fifth[enumerated.get(i).get(4)];
            String result = Character.toString(letter1) + letter2 + letter3 + letter4 + letter5;
            System.out.println(result);
        }
    }
}
