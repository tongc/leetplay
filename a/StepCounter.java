package a;

public class StepCounter {
    public int countSteps(int total, int current) {
        if(current == total) {
            return 1;
        }
        if(current > total) {
            return 0;
        }
        return countSteps(total, current + 1) +
                countSteps(total, current + 2);
    }

    public int minSteps(int total) {
        if(total < 0) {
            return 0;
        }
        if(total == 0) {
            return 0;
        }
        return Math.min(minSteps(total - 1) + 1, minSteps(total -2) + 1);
    }

    public static void main(String[] args) {
        System.out.println(new StepCounter().countSteps(4, 0));
        System.out.println(new StepCounter().minSteps(15));
        System.out.println(new StepCounter().minSteps(20));
    }
}
