class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer,Integer> h=new HashMap<>();

        for(int c:nums){
            h.put(c,h.getOrDefault(c,0)+1);
        }

        for(int i=0;i<nums.length;i++){
            if(h.get(nums[i])>nums.length/2){
                return nums[i];
            }
        }

        return 1;
        
    }
}





169. Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
