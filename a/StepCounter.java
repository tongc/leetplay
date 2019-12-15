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

    public static void main(String[] args) {
        System.out.println(new StepCounter().countSteps(4, 0));
    }
}
