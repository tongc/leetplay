package a;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

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

    public int countStepsAccumulate(List<String> steps, int total) {
        if(steps.size() == 0) {
            steps.add("1");
            steps.add("2");
            return countStepsAccumulate(steps, total);
        }
        if(steps.get(steps.size() - 1).length() == total) {
            return steps.get(steps.size() - 1).length();
        }
        if(steps.get(steps.size() - 1).length() > total) {
            return steps.get(steps.size() - 2).length();
        }
        IntStream.range(0, steps.size()-1).forEach(value -> {
            steps.add(steps.get(value) + "1");
            steps.add(steps.get(value) + "2");
        });
        return countStepsAccumulate(steps, total);
    }

    public int countStepsNOTAccumulate(List<String> steps, int total) {
        if(steps.size() == 0) {
            steps.add("1");
            steps.add("2");
            return countStepsNOTAccumulate(steps, total);
        }
        if(steps.get(steps.size() - 1).length() == total) {
            return steps.get(steps.size() - 1).length();
        }
        if(steps.get(steps.size() - 1).length() > total) {
            return steps.get(steps.size() - 2).length();
        }
        List<String> newSteps = new ArrayList<>();
        IntStream.range(0, steps.size()).forEach(value -> {
            newSteps.add(steps.get(value) + "1");
            newSteps.add(steps.get(value) + "2");
        });
        steps.clear();
        steps.addAll(newSteps);
        return countStepsNOTAccumulate(steps, total);
    }

    public static void main(String[] args) {
        System.out.println(new StepCounter().countSteps(4, 0));
        System.out.println(new StepCounter().minSteps(15));
        System.out.println(new StepCounter().minSteps(20));
        List<String> result = new ArrayList<>();
        System.out.println(new StepCounter().countStepsAccumulate(result, 10));
        System.out.println(result);

        List<String> result1 = new ArrayList<>();
        System.out.println(new StepCounter().countStepsNOTAccumulate(result1, 10));
        System.out.println(result1);
    }
}
