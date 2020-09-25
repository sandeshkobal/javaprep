/*
278. First Bad Version
Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad.
Implement a function to find the first bad version. You should minimize the number of calls to the API.
Given n = 5, and version = 4 is the first bad version.
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
*/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left=1, right=n;
        while(left<right){
            int mid = left+(right-left)/2;
            
            if(isBadVersion(mid))
                right = mid;
            else 
                left = mid+1;
        }
        return left;
    }
}

/*
https://leetcode.com/problems/find-the-duplicate-number/
READ ONLY ARRAY
Input: [1,3,4,2,2]
Output: 2
Input: [3,1,3,4,2]
Output: 3
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
*/
class Solution {
    // THIS IF WE ARE ALLOWED TO MODIFY AN ARRAY
    // idea is we jump to index 'nums[i]'
    // and keep jumping while making those numbers -ve  
    // if there is no duplicate jumping will happen for max nums.length 
    // if during jumps we find -ve number the index of that number is duplicate 
    public int findDuplicate1(int[] nums) {
        int jumpCount=0;
        int index1 = nums[0];
        
        while(jumpCount<nums.length){
            
            if(nums[index1]<0)
                return index1;
            
            int index2 = nums[index1];
            nums[index1] =  nums[index1]*-1;
            index1=index2;
            
            jumpCount++;
        }
        return -1;
    }
    
    // N.Log(N)
    public int findDuplicate(int[] nums) {
        int low=1, high=nums.length;
        while(low<high){    
            
            int mid=(low+high)/2;
            
            int count=0;
            for(int i=0; i<nums.length; i++){
                if(nums[i]<=mid){
                    count++;
                }                                
            }
            
            if(count<=mid)
                low = mid+1;
            else 
                high = mid;                                    
        }
        
        return high;
    }
}

/*
35. Search Insert Position
https://leetcode.com/problems/search-insert-position/
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Input: [1,3,5,6], 5
Output: 2
*/
// Think of [1,3,5,6] 7 OR  [2,3,4] 1
class Solution {
    public int searchInsert(int[] nums, int target) {
      
        int left=0, right=nums.length-1;
        
        if(target<nums[left]) 
            return 0; 
        
        if(target>nums[right])
            return right+1;
        
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]<target)
                left=mid+1;
            else
                right=mid;
        }
        return left;
    }
}
/*
167. Two Sum II - Input array is sorted
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if ( numbers==null || numbers.length == 0) {
            return new int[2];
        }
        int[] result = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
            if (sum < target) 
                left++;
            else
                right--;
        }
        return result;
    }
    
    /* If numbers are not sorted */
    public int[] twoSum(int[] numbers, int target) {
        // save the difference in map with index 
        // if difference found in map then return both indices
        int[] ans = new int[2];
        if(numbers==null) return ans;
        
        HashMap<Integer,Integer> table = new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){
            if(table.containsKey(numbers[i])){
                ans[0] = table.get(numbers[i]);
                ans[1] = i+1;
                return ans;
            }
            table.put(target-numbers[i],i+1);
        }
        return ans;
    }
}
