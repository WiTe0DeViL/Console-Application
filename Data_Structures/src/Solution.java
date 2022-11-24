class Solution {
    public void rotate(int[] nums, int k) {
        if(k>nums.length){
            k%=nums.length;
        }
        int len=nums.length;
        reverse(nums,len-k,len-1); // first block
        reverse(nums,0,len-k-1); // second block
        reverse(nums,0,len-1);

    }
    public void reverse(int[] nums,int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}