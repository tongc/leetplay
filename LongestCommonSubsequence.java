import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestCommonSubsequence {
    public void lcs() {

    }

    public List<String> allSubsequences(String input) {
        List<String> allSubsequences = new ArrayList<>();
        Arrays.stream(input.split("")).forEach(s -> {
            List<String> newList = allSubsequences.stream().map(eachSeq -> eachSeq + s.charAt(0)).collect(Collectors.toList());
            allSubsequences.add(s);
            allSubsequences.addAll(newList);
        });
        return allSubsequences;
    }

    public List<String> enumerateBase2(int numberOfDigits, int baseNumber) {
        List<String> results = new ArrayList<>();
        IntStream.rangeClosed(0, baseNumber - 1).forEach(value -> results.add(Integer.toString(value)));
        IntStream.range(1, numberOfDigits).forEach(value -> {
            List<String> newList = results.stream().map(s -> {
                List<String> newL = new ArrayList<>();
                IntStream.rangeClosed(0, baseNumber - 1).forEach(value1 -> newL.add(s + value1));
                return newL;
            }).flatMap(Collection::stream).collect(Collectors.toList());
            results.clear();
            results.addAll(newList);
        });
        return results;
    }

    public String lcs(List<String> first, List<String> second) {
        if(first.size() == 0 || second.size() == 0) {
            return "";
        }
        String firstLetter = first.get(0);
        String secondLetter = second.get(0);
        if(firstLetter.equals(secondLetter)) {
            first.remove(0);
            second.remove(0);
            return lcs(first, second) + firstLetter;
        } else if(first.size() == 1 || second.size() == 1) {
            return "";
        }
        String left = lcs(first.subList(1, first.size()), second);
        String right = lcs(first, second.subList(1, second.size()));
        return left.length()>right.length()?left:right;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        List<String> abcdef = lcs.allSubsequences("abcdef");
        System.out.println(abcdef + " size: " + abcdef.size());
        List<String> base2Enum = lcs.enumerateBase2(3, 2);
        System.out.println(base2Enum + " size: " + base2Enum.size());
        List<String> base10Enum = lcs.enumerateBase2(3, 10);
        System.out.println(base10Enum + " size: " + base10Enum.size());

        List<String> first = new ArrayList<>();
        first.add("a");
        first.add("b");
        first.add("c");
        first.add("d");
        first.add("f");
        first.add("g");
        first.add("g");

        List<String> second = new ArrayList<>();
        second.add("b");
        second.add("c");
        second.add("d");
        second.add("f");
        second.add("g");
        second.add("h");
        System.out.println(lcs.lcs(first, second));
    }
}
