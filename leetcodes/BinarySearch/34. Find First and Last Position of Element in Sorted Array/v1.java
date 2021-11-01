class v1 {
    int[] nums;
    int target;
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        this.nums = nums;
        this.target = target;
        int[] ret = new int[2];
        // 找上下两界： 正常二分+找到target还继续搜索
        ret[0] = binarySearchEdge(true);
        ret[1] = binarySearchEdge(false);
        return ret;
    }
    
    public int binarySearchEdge(boolean isLeftEdge) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int mid = r + (l - r) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid;
            } else { // == target
                if (isLeftEdge) {
                    // search to left:
                    r = mid;
                } else {
                    l = mid;
                }
            }
        }
        
        if (isLeftEdge) {
            if (nums[l] == target) {
                return l;
            } 
            if (nums[r] == target) {
                return r;
            }
            return -1;
        }
        // right edge:
        if (nums[r] == target) {
            return r;
        }
        if (nums[l] == target) {
            return l;
        } 
        return -1;
    }
}