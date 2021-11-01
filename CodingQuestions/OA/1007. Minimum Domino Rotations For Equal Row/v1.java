class v1 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // 使用两个长度为6的数组来记录每一个数字在每一行出现的次数。这一题没想到用长度为6的数组。
        // 如果可以有答案，那么说明上数组的某个数字数量 + 下数组的某个数字数量 - 相同的数量 == len
        // len - max(A,B) 就是翻转最小。
        int len = tops.length;
        int[] countA = new int[7];
        int[] countB = new int[7];
        int[] same = new int[7];
        
        for (int i = 0; i < len; i++) {
            countA[tops[i]]++;
            countB[bottoms[i]]++;
            if(tops[i] == bottoms[i])
                same[tops[i]]++; //相同的不算。
        }
        
        int ret = Integer.MAX_VALUE;
        for (int i = 1; i < 7; i++) {
            if (countA[i] + countB[i] - same[i] == len)
                return len - Math.max(countA[i], countB[i]);
        }

        return -1;
    }
}