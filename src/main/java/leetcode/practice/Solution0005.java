package leetcode.practice;

/**
 * Print the given string in a reverse order using recursion.
 */
public class Solution0005 {

    public void printStringInReverseOrder(String str) {
        switch(str.length()){
            case 0:
                break;
            case 1:
                System.out.print(str.charAt(0));
                break;
            default:
                printStringInReverseOrder(str.substring(1));
                System.out.print(str.charAt(0));
                break;
        }
    }

    public static void main(String[] args) {
        new Solution0005().printStringInReverseOrder("ankit");
    }


}
