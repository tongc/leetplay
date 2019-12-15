package a;

public class MinStepsToOne {
    public int minStepsToOne(int number) {
        if (number == 1) {
            return 0;
        }
        if (number < 1) {
            return 0;
        }
        if (number % 3 == 0 && number % 2 == 0) {
            return Math.min(minStepsToOne(number / 3) + 1,
                    Math.min(minStepsToOne(number / 2) + 1, minStepsToOne(number - 1) + 1));
        } else if (number % 3 == 0) {
            return Math.min(minStepsToOne(number / 3) + 1, minStepsToOne(number - 1) + 1);
        } else if (number %2 == 0) {
            return Math.min(minStepsToOne(number / 2) + 1, minStepsToOne(number - 1) + 1);
        } else {
            return minStepsToOne(number - 1) + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MinStepsToOne().minStepsToOne(10));
    }
}
