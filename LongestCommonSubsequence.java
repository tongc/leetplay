import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestCommonSubsequence {
    public void lcs() {

    }

    public List<String> allSubsequences(List<String> all, char newLetter) {
        return all.stream().map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s + newLetter;
            }
        }).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        List<String> allSubsequences = new ArrayList<>();
        Arrays.stream("abcdef".split("")).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                List<String> newList = lcs.allSubsequences(allSubsequences, s.charAt(0));
                allSubsequences.addAll(newList);
                allSubsequences.add(s);
            }
        });
        System.out.println(allSubsequences + " size: " + allSubsequences.size());
    }
}
