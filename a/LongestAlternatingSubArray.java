package a;

import java.util.ArrayList;
import java.util.List;

public class LongestAlternatingSubArray {
    public int las(List<Integer> input) {
        if(input.size() == 0) {
            return 0;
        }
        int longest = 0;
        int current = 0;
        boolean isLastPositive = input.get(0) >= 0;
        for(int i=1;i<input.size();i++) {
            boolean isCurrentPositive = input.get(i) >= 0;
            if(isLastPositive != isCurrentPositive) {
                current++;
            }
            if(isLastPositive == isCurrentPositive || i == input.size() - 1) {
                if(current > longest) {
                    longest = current;
                }
                current = 0;
            }
            isLastPositive = isCurrentPositive;
        }
        return longest;
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(-1);
        array.add(-1);
        array.add(-1);
        array.add(-1);
        array.add(-1);
        array.add(-1);
        array.add(-1);
        array.add(-1);
        array.add(-1);
        array.add(2);
        array.add(-3);
        array.add(4);
        array.add(-2);
        array.add(1);
        array.add(-3);
        array.add(3);
        array.add(2);
        array.add(-3);
        array.add(4);
        array.add(-2);
        array.add(1);
        array.add(-3);
        array.add(3);
        array.add(-3);
        array.add(2);
        array.add(-3);
        array.add(4);
        array.add(-2);
        array.add(1);
        array.add(-3);
        array.add(3);
        array.add(-2);
        array.add(1);
        array.add(-3);
        array.add(3);
        System.out.println(new LongestAlternatingSubArray().las(array));
    }
}
