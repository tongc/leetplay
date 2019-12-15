package a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonSubsequence {
    public void findCommonSubsequence(List<String> i1, List<String> i2, int i1Idx, int i2Idx, List<String> result) {
        System.out.println("i1:" + i1Idx + " i2:" + i2Idx);
        if(i1Idx >= i1.size() || i2Idx >= i2.size()) {
            return;
        }
        if(i1.get(i1Idx).equals(i2.get(i2Idx))) {
            result.add(i1.get(i1Idx));
            findCommonSubsequence(i1,i2,i1Idx+1,i2Idx+1,result);
        }
        findCommonSubsequence(i1,i2,i1Idx+1, i2Idx, result);
        findCommonSubsequence(i1,i2,i1Idx, i2Idx+1, result);
    }

    public static void main(String[] args) {
        List<String> s1 = Arrays.asList("abcde".split(""));
        List<String> s2 = Arrays.asList("ddddd".split(""));
        List<String> result = new ArrayList<>();
        new CommonSubsequence().findCommonSubsequence(s1, s2, 0, 0, result);
        System.out.println(result);
    }
}
