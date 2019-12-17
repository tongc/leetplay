package a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusMatrix {
    Map<List<Integer>, Integer> cache = new HashMap<>();
    public int maxNumOfPassengers(List<List<Integer>> busStops, int currentX, int currentY) {
        List<Integer> key = new ArrayList<>();
        key.add(currentX);
        key.add(currentY);
        int currentVal;
        if(!cache.containsKey(key)) {
            currentVal = busStops.get(currentX).get(currentY);
        } else {
            currentVal = cache.get(key);
        }
        if(busStops.size() == currentX + 1 && busStops.get(currentX).size() == currentY + 1) {
            return currentVal;
        }
        if(busStops.size() == currentX + 1) {
            return currentVal + maxNumOfPassengers(busStops, currentX, currentY + 1);
        }
        if(busStops.get(currentX).size() == currentY + 1) {
            return currentVal + maxNumOfPassengers(busStops, currentX + 1, currentY);
        }
        int max = Math.max(currentVal + maxNumOfPassengers(busStops, currentX + 1, currentY),
                currentVal + maxNumOfPassengers(busStops, currentX, currentY + 1));
        return max;
    }

    public static void main(String[] args) {
        List<List<Integer>> busStops = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(5);
        a.add(0);
        a.add(3);
        a.add(1);
        busStops.add(a);
        List<Integer> b = new ArrayList<>();
        b.add(4);
        b.add(2);
        b.add(0);
        b.add(2);
        b.add(4);
        busStops.add(b);
        List<Integer> c = new ArrayList<>();
        c.add(5);
        c.add(0);
        c.add(4);
        c.add(0);
        c.add(2);
        busStops.add(c);
        System.out.println(busStops);
        System.out.println(new BusMatrix().maxNumOfPassengers(busStops, 0, 0));
    }
}
