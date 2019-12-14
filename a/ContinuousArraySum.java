package a;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.IntStream;

public class ContinuousArraySum {
    public void findTheContinuousElementsThatSumsTo(int expected, List<Integer> inputArray) {
        int sum = 0;
        int current = 0;
        if (inputArray.stream().reduce(Integer::sum).orElse(-1) < expected) {
            System.out.println("no result found");
            return;
        }
        for (int i = 0, j = 0; j < inputArray.size() || i < inputArray.size(); ) {
            if (sum > expected) {
                sum -= inputArray.get(i);
                i++;
            } else {
                sum += inputArray.get(j);
                j++;
            }
            if (sum == expected) {
                System.out.println("positions from:" + i + " to:" + j);
                break;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> inputArray = new ArrayList<>();
        inputArray.add(1);
        inputArray.add(0);
        inputArray.add(1);
        inputArray.add(10);
        inputArray.add(2);
        inputArray.add(3);
        inputArray.add(4);
        inputArray.add(5);
        new ContinuousArraySum().findTheContinuousElementsThatSumsTo(26, inputArray);
        new ContinuousArraySum().findTheContinuousElementsThatSumsTo(25, inputArray);
        new ContinuousArraySum().findTheContinuousElementsThatSumsTo(24, inputArray);
        new ContinuousArraySum().findTheContinuousElementsThatSumsTo(200, inputArray);
        new ContinuousArraySum().findTheContinuousElementsThatSumsTo(7, inputArray);
        new ContinuousArraySum().findTheContinuousElementsThatSumsTo(9, inputArray);
        new ContinuousArraySum().findTheContinuousElementsThatSumsTo(12, inputArray);
        new ContinuousArraySum().findTheContinuousElementsThatSumsTo(19, inputArray);
    }
}
