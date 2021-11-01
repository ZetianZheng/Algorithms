给一个包含N个数的数列A，要求找到一个maximum possible K(0~N-1)使
```
|A[i] - A[j]| = |i - j| = K
```
ex1:
```
intput: [2,2,2,1]   
output: 1
explanation: A[2] = 2, A[3] = 1,
|A[2] - A[3]| = |2 - 1| = 1
```

```
intput: [2, 4, 6, 7, 4, 7, 2]  
output: 5
explanation: A[0], A[5]
```

N: 1...100000  
each of Element in A:   
0 ..... 1,000,000,000

<!-- # v1:
暴力解求最大，O(n^2)

# v2:
移向 + hashMap, t: O(n)  s: O(n)
1. 移向：
   ```
   i < j
   |i - j| = |A[i] - A[j]|
   1. i - j = A[i] - A[j] --> i - A[i] = j - A[j]
   2. i - j = A[j] - A[i] --> i + A[i] = j + A[j]
   ```
2. 使用两个hashMap 来记录 x - A[x] 和 x + A[x]， x, 用k记录出现过的最大值。 -->