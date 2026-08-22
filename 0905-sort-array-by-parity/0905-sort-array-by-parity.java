class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            // If left is odd and right is even, swap them
            if (nums[left] % 2 != 0 && nums[right] % 2 == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            } else {
                // Advance left if it's already pointing to an even number
                if (nums[left] % 2 == 0) {
                    left++;
                }
                // Advance right if it's already pointing to an odd number
                if (nums[right] % 2 != 0) {
                    right--;
                }
            }
        }
        
        return nums;
    }
}