删除B， 左右两边删除cost为1， 中间删除cost为2，输入一个字符串，求返回没有b的字符串的最小代价。

```
input: aabaa
output: 2
```
```
input: abbaaba
output: 5
->1 bbaaba ->1 baaba ->1 aaba ->2 aaa/aa
```
```
input: bbb
output: 3
```

<!-- 使用两个dp数组，一个从左往右遍历，一个从右往左，记录到当前的cost最小值是多少， 所以针对每一个位置的两个dp相对应值的之和就是所有的cost，
比如aaba
dpleft = 0,0,2,2
dpright = 2,2,2,0

状态转移： 
dp[i] = dp[i-1], if (current position equals to A)
dp[i] = (i, dp[i - 1] + 2) 当前是b的两种的两种情况，一种是直接从头删到尾，一种是上一个cost  + 2, 

特殊情况：
bbb
起始判断一下是否全部是b全部是b直接返回n -->