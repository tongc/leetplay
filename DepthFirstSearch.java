public class DepthFirstSearch {
    int counter = 0;
    public int dfs(int levels) {
        if(levels >= 3) return 0;
        System.out.println("1");
        int val = dfs(levels+1) + 1;
        System.out.println("2");
        return val + dfs(levels+1) + 1;
//        System.out.println("3");
//        dfs(levels+1);
    }

    public static void main(String[] args) {
        System.out.println("final" + new DepthFirstSearch().dfs(0));
        /**
         *111
         * 112
         * 113
         * 121
         * 122
         * 123
         * 311
         * 312
         * 313
         * steps 0
         * steps 1
         * steps 2
         * steps 3
         *
         */
    }
}
