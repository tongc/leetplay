import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BiggestNumber {
    public String biggestCombination(List<String> input) {
        Collections.sort(input, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy = x + y;
                String yx = y + x;
                return yx.compareTo(xy);
            }
        });
        return input.toString();
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        input.add("543");
        input.add("1");
        input.add("33");
        input.add("9");
        input.add("88");

        System.out.println(new BiggestNumber().biggestCombination(input));


    }
}
