import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BaseNEnumerator {
    /**
     * baseSize <= 10
     * @param baseSize
     * @param numOfDigits
     * @return
     */
    public List<List<Integer>> enumerator(int baseSize, int numOfDigits) {
        assert baseSize <= 10;
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        results.get(0).add(0);
        while(results.size() < Math.pow(baseSize, numOfDigits)) {
            results.add(nextNum(results.get(results.size()-1), baseSize));
        }
        return results;
    }

    public List<Integer> nextNum(List<Integer> currentNumber, int baseSize) {
        List<Integer> next = new ArrayList<>(currentNumber);
        for(int i=0;i<next.size();i++) {
            if(next.get(i) < baseSize - 1) {
                next.set(i, next.get(i) + 1);
                break;
            } else {
                next.set(i, 0);
            }
        }
        if(next.get(next.size()-1) == 0) {
            next.add(1);
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
    }
}
