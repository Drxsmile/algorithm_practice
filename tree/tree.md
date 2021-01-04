# tree
## binary tree

### traversal

#### dfs
preOrder
inOrder
postOrder

#### bfs
levelOrder
[leetcode link](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

1. why use queue?How does the queue keep order?
   e.g. the binary tree in the ppt
   [A]
   A [B C]
   A B [C D E]
   A B C [D E F G]
   A B C D [E F G]
   A B C D E [F G H I]
   A B C D E F [G H I]
   A B C D E F G [H I J]
   A B C D E F G H [I J]
   A B C D E F G H I [J]
   A B C D E F G H I J []



2. 如果需要分层呢？

   **solution 1**
   上一层和下一层分别放入两个队列，第一个队列global

   ```java
   q1 = q2;
   q2 = new LinkedList();
   ```

   **solution 2**
   上一层和下一层之间放一个null

   **solution 3**
   对每层计数 count = queue.size()

   **solution 4**
   dfs，记录level，把同一level的放入对应index的list里



### max depth

recursion 

左右子树里大的+1

### min depth

- recursion：子树可能为null
- bfs：第一个出现叶子节点的层     时间复杂度低

### same tree

以一个node为整体递归，base case是基于这个节点的，不要往子树看

### Symmetric Tree

问题：当前树是否是轴对称

子问题：左子树是否轴对称，右子树是否轴对称 XXXXXX

问题==左子树和右子树是否对称

子问题：

left.val == right.val;

left.left 对称 right.right;

left.right 对称 right.left;

### path sum

回溯

## binary search tree

### features

left < root < right

if we do in-order traversal,  we will get a sorted array

all subtrees are binary search tree

if we have duplicates, we can add a parameter "count" in the TreeNode

### functions

- add   time complexity: o(logn)

- remove 
1. 叶子
直接删就行
2. 有一个child
4种情况：被删在左在右，被删的child在左在右，经分析都可以直接用child代替这个节点
3. 有2个child
左子里面最大的，右子里面最小的，不一定是leaf

- find  time complexity: o(logn)

用recursion耗费空间，不断调用函数放到栈里，可以用while写









