/**
 * Given a string, check if it is a palindrome by ignoring spaces.
 * E.g. "race car" would be a palindrome.
 */
public class Solution0001 {
    public static void main(String...args) {
        Solution0001 solution = new Solution0001();

        String testString = "R ac eca r";
        if(solution.isPalindrome(testString)){
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
    public boolean isPalindrome (String str) {
        // If the string is null or empty then return true
        if (str == null || str == "") {
            return true;
        }
        int left = 0, right = (str.length() - 1);
        while (left <= right) {
            if (str.charAt(left) == ' '){
                left++;
            }
            if (str.charAt(right) == ' '){
                right--;
            }
            if (left >= right) {
                return true;
            } else {
                if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                    return false;
                }
            }
            left++;
            right--;
        }
        return false;
    }
}
