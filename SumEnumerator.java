import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SumEnumerator {
    public static void main(String[] args) {
        int[] data = new int[]{2,3,4,5,6,7,8};
        find(data);
    }

    private static void find(int[] data) {
        Map<Integer, List<Integer>> result = Arrays.stream(data).boxed().collect(Collectors.toMap(key -> key,
                integer -> new ArrayList<>()));
        for(int i=0;i<data.length;i++) {
            for(int j=0;j<data.length&&j!=i;j++) {
                int sum = data[i] + data[j];
                if(result.containsKey(sum)) {
                    result.get(sum).add(i);
                    result.get(sum).add(j);
                }
            }
        }
        System.out.println(result);
    }
}
