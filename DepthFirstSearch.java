public class DepthFirstSearch {
    int counter = 0;
    public int countAllNodesBase2(int levels) {
        if(levels <= 0) return 0;
        System.out.println("1");
        int val = countAllNodesBase2(levels-1) + 1;
        System.out.println("2");
        return val + countAllNodesBase2(levels-1) + 1;
    }

    public int countLeafOnlyBase2(int levels) {
        if(levels <= 0) return 1;
        int val = countLeafOnlyBase2(levels-1);
        return val + countLeafOnlyBase2(levels-1);
    }

    public int countAllNodesBase10(int levels) {
        if(levels <= 0) return 0;
        int val = countAllNodesBase10(levels-1) + 1;
        val += countAllNodesBase10(levels-1) + 1;
        val += countAllNodesBase10(levels-1) + 1;
        val += countAllNodesBase10(levels-1) + 1;
        val += countAllNodesBase10(levels-1) + 1;
        val += countAllNodesBase10(levels-1) + 1;
        val += countAllNodesBase10(levels-1) + 1;
        val += countAllNodesBase10(levels-1) + 1;
        val += countAllNodesBase10(levels-1) + 1;
        return val + countAllNodesBase10(levels-1) + 1;
    }

    public static void main(String[] args) {
        /**
         * below returns 14 which is
         * 8 + 4 + 2 (bottom-up)
         * there are 3 levels (4 levels if include root), and the first level is of 2 nodes and leaf level is of 8 nodes.
         */
        System.out.println("final" + new DepthFirstSearch().countAllNodesBase2(3));
        /**
         * below returns 11110 which is
         * 10000 + 1000 + 100 + 10 (bottom-up)
         * three are four levels (5 levels if include root), and the first level is of 10 nodes and leaf level is of 10000 nodes.
         */
        System.out.println("final" + new DepthFirstSearch().countAllNodesBase10(4));
        System.out.println("final" + new DepthFirstSearch().countLeafOnlyBase2(3));
    }
}
