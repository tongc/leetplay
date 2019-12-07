import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class TowerOfHanoi {
    public static void main(String[] args) {
        List<Integer> src = new ArrayList();
        List<Integer> intm = new ArrayList();
        List<Integer> dest = new ArrayList();


    }

    public int solve(List<Integer> src, List<Integer> intm, List<Integer> dest) {
        src.stream().max(Integer::compareTo).ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer max) {
                src.forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer each) {
                        intm.add(each);
                    }
                });
                src.removeAll(intm);
                dest.add(max);
                src.remove(max);
            }
        });
        return 0;
    }
}
