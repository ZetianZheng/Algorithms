class Solution {
    int[] nums;
    int target;
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int n = nums.length - 1;
        // 二分搜索加难版本，需要先定位k
        int k = find_rotate_index(0, n);
        // System.out.println(k);
        
        if (nums[k] == target)
            return k;
        if (k == 0)
            return binarySearch(0, n);
        if (target < nums[0]) {// search from other hand.
            return binarySearch(k, n);
        } 
        
        return binarySearch(0, k - 1);
    }
    
    public int binarySearch(int l, int r) {
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        
        if (nums[l] == target) {
            return l;
        }
        
        if (nums[r] == target) {
            return r;
        }
        
        return -1;
    }
    
    public int find_rotate_index(int l, int r) {
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]){
                l = mid;
            } else {
                r = mid;
            }
        }
        
        if (nums[l] > nums[r])
            return r;
        
        return l;
    }
    
    
}