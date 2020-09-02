
/*
https://leetcode.com/problems/maximum-product-subarray/
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) 
which has the largest product.
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
*/
// From this [3,3,-2,4,4] you can tell it needs 2 pass L->R & R->L
// corner case is if there is zero [3,3,0,4,4]
// at that point you have to make product 1 to continue processing 
class Solution {
    public int maxProduct(int[] nums) {
        
        if(nums==null || nums.length==0)
            return 0;
        
        int prod =1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            prod=prod*nums[i];
            max=Math.max(prod,max);
            if(prod==0) 
                prod=1;
        }
        
        prod=1;
        for(int i=nums.length-1;i>=0;i--){
            prod=prod*nums[i];
            max=Math.max(prod,max);
            if(prod==0) 
                prod=1;
        }
        
        return max;
    }
}
