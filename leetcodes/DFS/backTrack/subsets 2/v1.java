class v1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums == null) return ret;
        if (nums.length == 0) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        
        List<Integer> subset = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, subset, 0, ret);
        return ret;
    }
    
    public void dfs(int[] nums, 
                    List<Integer> subset, 
                    int ind, 
                    List<List<Integer>> ret) {
        ret.add(new ArrayList<Integer>(subset));
        
        for (int i = ind; i < nums.length; i++) { // 以每一个点为起点开始dfs
            if (i != ind && nums[i - 1] == nums[i]) {
                continue; // avoid duplication
            }
            subset.add(nums[i]);
            dfs(nums, subset, i + 1, ret); // i + 1.
            subset.remove(subset.size() - 1);
        }
    }
}