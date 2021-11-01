class v1 {
    public boolean search(int[] nums, int target) {
        // find pivot,
        int n = nums.length - 1;
        int pivot = binaryFindPivot(nums);
        
        if (pivot == 0)
            return binarySearch(nums, target, 0, nums.length - 1);
        if (nums[0] > target) {
            return binarySearch(nums, target, pivot, nums.length - 1);
        } else {
            return binarySearch(nums, target, 0, pivot - 1);
        }
    }
    
    public int binaryFindPivot(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums[0] < nums[r]) {
            return 0;
        }
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            if (nums[mid] < nums[r]) {
                // pivot not in the right side
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else { 
                // nums: mid==r, 
                // 遍历，把r左移, 找到 r左边比r大。
                if(r > 0 && nums[r - 1] > nums[r]) {
                    return r;
                } else { // 最差情况变为O(n) 110111
                    r -= 1;
                }
            }
        }
        
      return l;
    }
    
    public boolean binarySearch(int[] nums, int target, int l, int r) {
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] < target) {
                // pivot not in the right side
                l = mid;
            } else {
                r = mid;
            }
        }
        
        if (nums[l] == target) {
            return true;
        } else if (nums[r] == target){
            return true;
        }
        
        return false;
    }
}