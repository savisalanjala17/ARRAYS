class Solution {
    public int findLucky(int[] arr) {
        

        HashMap<Integer,Integer> h = new HashMap<>();

        for(int i=0 ;i<arr.length;i++){
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
        }

        int count=-1;
        int maxi=-1;
     
      for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            if(entry.getKey().equals(entry.getValue())){
                count=entry.getKey();
                maxi=Math.max(count,maxi);

            }
            
        }

        

        return maxi;

    }
}



1394. Find Lucky Integer in an Array
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.

Return the largest lucky integer in the array. If there is no lucky integer return -1.

 

Example 1:

Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
Example 2:

Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
Example 3:

Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.
 

Constraints:

1 <= arr.length <= 500
1 <= arr[i] <= 500
