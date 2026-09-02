class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ws=0;
        int left=0;
        double maxavg=Double.NEGATIVE_INFINITY,avg;
        for(int i=0;i<nums.length;i++){
            ws+=nums[i];
            if(i-left+1>k){
                ws-=nums[left];
                left++;
            }
            if(i-left+1==k){
                avg=ws/k;
                if(avg>maxavg){
                    maxavg=avg;
                }
            }
        }
        return maxavg;
    }
}