# Dynamic Programming
## 如何判断是否用dp
1. 求最优解
2. 有重叠子问题，用dp数组记录下来
3. 有最优子结构，子问题相互独立，通过子问题的最值得到原问题的最值

## 如何dp
- 当子问题重复计算的时候，记录子问题的解
- 大部分子问题可以通过缩小scope解决，就是看前一个index
- 动态规划一般做空间上的优化

## 思路
1. 状态转移方程（类似于递归关系式）

- 状态，自变量x，原问题和子问题中会变化的变量
- 选择，导致「状态」产生变化的行为
- dp数组/函数的定义，f(x)，随着状态的变化，问题要求的最值
- base case

2. 优化（状态压缩）     
一般是空间上的优化

## 模板

### type 1 背包问题

0-1背包

完全背包

### type 2 longest increasing subsequence

- 状态：

由于一个子序列一定会以一个数结尾，于是将状态定义成：dp[i] 表示 以 nums[i] 结尾 的「上升子序列」的长度。注意：这个定义中 nums[i] 必须被选取，且必须是这个子序列的最后一个元素；



- 状态转移方程：

在下标 `i` 之前严格小于 `nums[i]` 的所有状态值中的最大者 + 1



- 优化：to do 

### type 3 longest common subsequence

- 状态

```
dp[i][j]代表A字符串在i-1位置和B字符串在j-1位置的lcs
```

- 状态转移方程

```
if(A[i-1] == B[j-1]) 
	dp[i][j] = dp[i-1][j-1] + 1;
else{
	dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
}
```



### Type 4 matrix chain multiplication

[参考资料1：这个表格一看就懂](https://blog.csdn.net/qq_32919451/article/details/80643118?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.control&dist_request_id=ba60ece0-1dda-4499-8a77-bb8a55bdb35e&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.control)

[参考资料2：这个介绍了求最优子结构的过程](https://blog.csdn.net/qq_16234613/article/details/52223410)

