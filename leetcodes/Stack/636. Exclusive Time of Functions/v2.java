class v2 {
    public int[] exclusiveTime(int n, List<String> logs) {
        // 使用stack，每次看到start的时候就入栈id，看到end就出栈id，因为是单线程的，所以出栈的必定是上一个进程。
        // 每次有进程进来，肯定会对栈顶的进程进行一个timestamp增加的操作。比如exp1中1：start:2,那么栈顶是进程0，时间增加2-0 = 2.
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        int lastTimeStamp = 0;
        for (String content : logs) {
            // id : flag : timeStamp
            Log log = new Log(content);
            
            // 先累加time：
            if (!stack.isEmpty()) {
                ans[stack.peek()] += (log.timeStamp - lastTimeStamp);
            }
            
            // 再对栈进行操作：
            if (log.isStart) {
                stack.push(log.id);
            } else {
                ans[stack.peek()]++; // 出栈的时间节点也算一个。
                log.timeStamp++; 
                stack.pop();
            }
            lastTimeStamp = log.timeStamp;
        }
        
        return ans;
    }
    // 使用static函数独立出来log。
    public static class Log {
        public int id;
        public boolean isStart;
        public int timeStamp;
        
        public Log(String content) {
            String[] logArr = content.split(":");
            id = Integer.parseInt(logArr[0]);
            isStart = logArr[1].equals("start");
            timeStamp = Integer.parseInt(logArr[2]);
        }
    }
}
