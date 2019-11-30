import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class BreathFirstSearch {
    static Map<Integer, Node> cache = new HashMap<>();

    static class Node {
        public Node(int val) {
            this.val = val;
        }

        int val;
        List<Node> connected = new ArrayList<>();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val &&
                    Objects.equals(connected, node.connected);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, connected);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", children size=" +
                    connected.size() + '}';
        }
    }

    public static void main(String[] args) {
        IntStream.range(0, 10).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                Node node = new Node(value);
                cache.put(value, node);
            }
        });
        cache.get(1).connected.add(cache.get(2));
        cache.get(1).connected.add(cache.get(3));
        cache.get(1).connected.add(cache.get(4));
        cache.get(1).connected.add(cache.get(5));
        cache.get(2).connected.add(cache.get(3));
        cache.get(2).connected.add(cache.get(4));
        cache.get(3).connected.add(cache.get(5));
        cache.get(3).connected.add(cache.get(6));
        cache.get(4).connected.add(cache.get(7));
        cache.get(7).connected.add(cache.get(8));
        cache.get(8).connected.add(cache.get(9));

        List<Node> from = new ArrayList<>();
        from.add(cache.get(1));
        bfs(from);
        System.out.println(nodesBfs);
    }

    static Set<Node> visited = new HashSet<>();
    static List<List<Node>> nodesBfs = new ArrayList<>();

    public static void bfs(List<Node> nodes) {
        if (nodes.size() == 0) return;
        List<Node> nextLayer = new ArrayList<>();
        visited.addAll(nodes);
        nodes.forEach(node -> node.connected.stream()
                        .filter(innerNode -> !visited.contains(innerNode))
                        .forEach(nextLayer::add));
        nodesBfs.add(nextLayer);
        bfs(nextLayer);
    }
}
