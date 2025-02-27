package com.awsravi.leetcode_practices.leetcode;

public class IsHappy {
    public static void main(String[] args) {
        IsHappy happy = new IsHappy();
        System.out.println(happy.isHappy(19)); // Example usage
        System.out.println(happy.isHappy(2));
    }
    /*
    The do...while loop and the "slow and fast pointer" approach are correct for detecting cycles.
    The return statement was corrected to return slow == 1;
    The creation of an object of the class IsHappy and the addition of example usages in the main method were added.
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        return slow == 1;
    }
/*
findSquare Method:

The original findSqare method had a critical error: ans /= ans * rem;.
This would lead to incorrect calculations and potential division by zero.
The corrected code uses ans += rem * rem;,
which correctly calculates the sum of the squares of the digits.
 */
    static int findSquare(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10;
            ans += rem * rem; // Corrected: sum of squares
            number /= 10;
        }
        return ans;
    }
}