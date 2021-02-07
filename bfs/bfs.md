# bfs
解决最小的问题（最小路径、最小距离……），也可能用栈，dp，堆
## when use bfs？
遇到二叉树，类似图（迷宫……）求最小距离
dp一般处理数字

## Queue循环
Queue is an interface in java
```java
Queue<> q = new LinkedList<>();
q.offer(); // return false if fail
q.poll();// return null if fail
q.peek();// return null if fail

// throw exception
q.add();
q.remove();
q.element();
```

## 模板

## 思路

1. 建图
2. 确定起始点，加到队列里
除了队列也可以是其他容器，set可以去重
3. 确定几个方向


计算距离和：（shortest distance from all buildings）
- 用一个同等size的matrix记录distance
- 起始点和终点是可以反过来的，选择数量少的作为起始点，进行bfs的次数就少
- 起始点和终点数量未知，也用一个同等size的matrix记录当前点被计算的次数，因为不知道数量，没办法立刻比较，只能全部遍历后，再遍历一次结果比较大小，不然可能这个点的距离和小，但是是因为它没有到达所有的终点
