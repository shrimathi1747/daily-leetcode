class Solution {
  

        
    // Helper method to compute sum of squares of digits
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n /= 10;
        }
        return totalSum;
    }

     public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        // Loop until fast hits 1 or fast catches up with slow (cycle detected)
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);             // Move 1 step
            fast = getNext(getNext(fast));    // Move 2 steps
        }

        return fast == 1;
    }
}
    