class Solution {
    public String simplifyPath(String path) {
        // 使用栈，然后重新拼装成canonical path
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        System.out.println(Arrays.toString(paths));
        for (String pa : paths) {
            if (pa.equals(".") || pa.equals("")) 
                continue;
            if (pa.equals("..") && !stack.isEmpty()) { // 当前是 .. 的情况且栈不为空，回到上一层
                stack.pop();
                continue;
            }
            if (pa.equals("..") && stack.isEmpty()) { // 当前是 .. 的情况且栈为空,什么都不做
                continue;
            }
            stack.push(pa);
        }
        
        String ret = "";
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            ret = "/" + stack.pop() + ret;
        }
        
        return ret.length() > 0 ? ret : "/";
    }
}
