class v1 {
    public int calculate(String s) {
        // 使用栈来进行运算，每次遇到+，直接将下一个数入栈，如果遇到-，将下一个数变负数入栈。遇到乘或者除，则将栈顶元素pop除做乘除运算再入栈。
        Stack<Integer> stack = new Stack<>();
        char[] chrs = s.toCharArray();
        int num = 0;
        int sum = 0;
        char sign = '+'; // initalize, 初始符号为 +，这样第一个数可以直接加进来。
        for (int i = 0; i < chrs.length; i++){
            if (Character.isDigit(chrs[i])) { // 计算当前数字
                num = num * 10 + (chrs[i]-'0');
            } 
            // 每个数的状态跟它前面的符号挂钩，根据之前的sign来判断怎么入栈当前数字，再更新sign。
            if (!Character.isDigit(chrs[i]) && ' ' != chrs[i] || chrs.length - 1 == i) {
                if (sign == '+')
                    stack.push(num);
                else if (sign == '-')
                    stack.push(-num);
                else if (sign == '*') 
                    stack.push(stack.pop() * num);
                else if (sign == '/') 
                    stack.push(stack.pop() / num);
                
                sign = chrs[i];
                num = 0;
            }
        }
        
        for (int n : stack) {
            // System.out.println(n);
            sum += n;
        }
        
        return sum;
    }
}