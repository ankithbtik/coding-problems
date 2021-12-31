import java.util.HashSet;
import java.util.Set;

/**
 * Given a positive integer k, you need to find the length of the smallest positive integer n such that n is divisible by k, and n only contains the digit 1.
 * Return the length of n. If there is no such n, return -1.
 * Note: n may not fit in a 64-bit signed integer.
 *
 * Leetcode problem : https://leetcode.com/problems/smallest-integer-divisible-by-k/
 */
public class Solution0004 {
    public int smallestRepunitDivByK(int k) {
        if(k==0 || (k%2==0) || (k%5==0)){
            return -1;
        }

        Set<Integer> remainders = new HashSet<>();
        int remainder = 1;
        int size = 1;

        while(remainder%k != 0){
            remainder = ((remainder*10)+1)%k;
            size++;

            if(remainders.contains(remainder)){
                return -1;
            } else{
                remainders.add(remainder);
            }
        }
        return size;

    }
}
