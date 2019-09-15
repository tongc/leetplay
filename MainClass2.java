/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return toListNode(plus(l1,l2,"", false).split(""));
    }

    private String plus(ListNode l1, ListNode l2, String result, boolean carry) {
        if(l1==null && l2==null) {
            return carry?result+"1":result;
        }
        int firstVal = 0;
        int secondVal = 0;
        if(l1!=null) {
            firstVal = l1.val;
        }
        if(l2!=null) {
            secondVal = l2.val;
        }
        if(firstVal + secondVal + (carry?1:0)>= 10) {
            result += String.valueOf(firstVal + secondVal + (carry?1:0) - 10);
            return plus(l1==null?null:l1.next, l2==null?null:l2.next, result, true);
        } else {
            result += String.valueOf(firstVal + secondVal + (carry?1:0));
            return plus(l1==null?null:l1.next, l2==null?null:l2.next, result, false);
        }
    }

    private ListNode toListNode(String[] values) {
        ListNode result = new ListNode(Integer.parseInt(values[0]));
        ListNode next = result;
        for (int i = 0; i <values.length-1; i++) {
            next.next = new ListNode(Integer.parseInt(values[i+1]));
            next = next.next;
        }
        return result;
    }
}

public class MainClass2 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = new Solution().addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}