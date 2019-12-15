package a;

import java.util.ArrayList;
import java.util.List;

public class RemoveAdjacentDuplicates {

    public List<String> removeAdjacentDupElements(List<String> input, String lastElement, int position) {
        if(position == input.size()) {
            return input;
        }
        if(lastElement.equals(input.get(position))) {
            input.remove(position);
            return removeAdjacentDupElements(input, lastElement, position);
        }
        return removeAdjacentDupElements(input, input.get(position), position+1);
    }

    public static void main(String[] args) {
        List<String> inputArray = new ArrayList<>();
        inputArray.add("x");
        inputArray.add("x");
        inputArray.add("x");
        inputArray.add("y");
        inputArray.add("a");
        inputArray.add("b");
        inputArray.add("b");
        inputArray.add("b");
        inputArray.add("b");
        inputArray.add("b");
        inputArray.add("c");
        inputArray.add("c");
        inputArray.add("c");
        inputArray.add("c");
        System.out.println(new RemoveAdjacentDuplicates().removeAdjacentDupElements(inputArray, "x", 1));
    }
}
