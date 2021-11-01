class v1 {
    String s;
    int n; 
    LinkedList<String> segments = new LinkedList<>();
    List<String> ret = new ArrayList<>();
    
    public List<String> restoreIpAddresses(String s) {
        // 有效ip地址在0 ~ 256之间。
        // 排列类问题，使用dfs
        // 查询每一个放点的位置，找到所有的可能。
        // s的length最多4个255 也就是12 和，能放点的位置有11个，所以一共有11 * 10 * 9 = 990中可能
        //但是如果一个点放下去了下一个点实际只有三个可能去放： 1，2，3个数字之后。所以可以简化到 3 * 3 * 3 = 27中可能。
        n = s.length();
        this.s = s;
        dfs (-1, 3); // 之前放点的位置，放点的剩余数量。
        
        return ret;
    }
    
    public void dfs(int prev_pos, int dots) {
        int max_pos = Math.min(prev_pos + 4, n - 1); // last pos or max to 3 pos.
        for (int curr_pos = prev_pos + 1; curr_pos < max_pos; curr_pos++) {
            String seg = s.substring(prev_pos + 1, curr_pos + 1);
            if(valid(seg)) {
                segments.add(seg);
                if (dots - 1 == 0) {
                    update_output(curr_pos);
                } else {
                    dfs(curr_pos, dots - 1);
                }
                segments.removeLast(); // back tracking
            }
        }
    }
    
    public void update_output(int curr_pos) {
        String segment = s.substring(curr_pos + 1, n);
        if (valid(segment)) {
            segments.add(segment);
            ret.add(String.join(".", segments)); // 拼接数组
            segments.removeLast(); //拼接答案后并没有结束，还需要继续往后遍历。
        }
    }
    
    public boolean valid(String seg) {
        if (seg.length() > 3) {
            return false;
        }
        
        int num = Integer.valueOf(seg);
        if (num > 255 || (seg.charAt(0) == '0' && seg.length() != 1)) {
            return false;
        }
        // return seg.charAt(0) == '0' ? (num <= 255) : (seg.length() != 1)
        return true;
    }
}