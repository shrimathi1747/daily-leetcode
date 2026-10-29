class Solution {
    public int divisorSubstrings(int num, int k) {
        int temp=num;
        int count=0;
        int divisor=1;
        for(int i=0;i<k;i++){
            divisor*=10;
        }
        while(temp>=divisor/10){
            int window=temp%divisor;
            if(window!=0 && num%window==0){
                count++;
            }
            temp/=10;
        }
        return count;
    }
}