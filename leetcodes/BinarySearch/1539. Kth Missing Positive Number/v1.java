class v1 {
    public int findKthPositive(int[] arr, int k) {
        if (k < arr[0])// 如果k小于第一个值，那么直接返回自己即可。
            return k;
        
        k -= arr[0] - 1; // 前面缺失了arr[0] - 1个值。
        int n = arr.length;
        for (int i = 0;  i < n - 1; i++) { 
            int currentMissing = arr[i + 1] - arr[i] - 1; // 这两者中间缺失了多少值。
            if (k - currentMissing <= 0) {
                return arr[i] + k;
            } 
            
            k -= currentMissing;
        }
        
        return arr[n - 1] + k;
    }
}