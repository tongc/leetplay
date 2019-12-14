package a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MinimalElement {
    public int findMinElementInRotatedSortedArray(List<Integer> inputArray) {
        if(inputArray.size() == 0) {
            return 0;
        }
        if(inputArray.size() == 1) {
            return inputArray.get(0);
        }
        boolean rotated = false;
        if(inputArray.get(0) > inputArray.get(inputArray.size()-1)) {
            rotated = true;
        } else {
            return inputArray.get(0);
        }

        for(int i=0;i<inputArray.size()-1;i++) {
            if(inputArray.get(i) > inputArray.get(i+1)) {
                return inputArray.get(i+1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> inputArray = new ArrayList();
        inputArray.add(1);
        inputArray.add(2);
        inputArray.add(3);
        inputArray.add(4);
        System.out.println(new MinimalElement().findMinElementInRotatedSortedArray(inputArray));

        List<Integer> inputArray2 = new ArrayList();
        inputArray2.add(5);
        inputArray2.add(6);
        inputArray2.add(2);
        inputArray2.add(3);
        inputArray2.add(4);
        System.out.println(new MinimalElement().findMinElementInRotatedSortedArray(inputArray2));

        List<Integer> inputArray3 = new ArrayList();
        inputArray3.add(2);
        inputArray3.add(1);
        System.out.println(new MinimalElement().findMinElementInRotatedSortedArray(inputArray3));
    }
}
