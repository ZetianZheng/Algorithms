class v1 {
    public int[] findBuildings(int[] heights) {
        // 维护一个单调递增栈即可。从右往左入栈，如果比栈顶小则抛弃。
        
        int n = heights.length;
        List<Integer> ret = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {
            if (stk.size() != 0 && heights[i] <= stk.peek()) {
                continue;  
            }
            
            stk.push(heights[i]);
            ret.add(i);    
        }
                
        Collections.reverse(ret); // We can make use of the In-built Collections.reverse() method for reversing an arraylist. It takes a list as an input parameter and returns the reversed list.

        return ret.stream().mapToInt(i -> i).toArray(); // Using streams API of collections in java 8 to convert to array of primitive int type
    }
}