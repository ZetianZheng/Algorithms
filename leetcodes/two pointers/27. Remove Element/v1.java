public class v1 {
    public int removeElement(int[] nums, int val) {
        // 快慢指针， 每当找到一个非value的值就把它赋给慢指针。
        int i = 0; // 慢指针
        for (int j = 0; j < nums.length; j++) { // 快指针找不是val的值，并将值和慢指针对换。
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        
        return i;
    }
}