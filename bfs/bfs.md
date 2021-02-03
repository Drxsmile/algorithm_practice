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
3. 确定几个方向