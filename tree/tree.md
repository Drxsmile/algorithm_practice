# tree
## binary tree

### traversal

/***** iterative
     * 遍历是在遍历所有子树的根，叶子节点也是子树
     * 所以取值的顺序就是看子树的顺序
     * 前序：根，左，右 ==== 根，左子树的根，右子树的根，所以拿到上面的根的时候就取值
     * 中序：左，根，右 ==== 左子树的根，根，右子树的根，所以拿到最下面的左子树根的时候取值
     * 后序：左，右，根 ==== reverse（根，右，左）==== reverse（ 根，右子树的根，左子树的根，所以拿到上面的根的时候就取值）
     */
#### dfs
preOrder
inOrder
postOrder

#### bfs
levelOrder
[leetcode link](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

1. why use queue?How does the queue keep order?
   e.g. the binary tree in the ppt
   ```
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
   ```
```



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

### [Binary Tree Right Side View](https://leetcode-cn.com/problems/binary-tree-right-side-view/)

需要每层最右边的元素，可以先遍历root，然后右子树，左子树

### Binary Tree Maximum Path Sum
二叉树里任意2点可以构成一条路径，或者单独一个点，所以有
${n}\choose {1}$ + ${n}\choose {2}$ = ${n(n+1)} \over 2$个情况

数量太大，要简化

### Find Leaves of Binary Tree
res.get(level).add(root.val);
遍历求高度顺便加了叶子节点的值

## binary search tree

### features

left < root < right

if we do in-order traversal,  we will get a sorted array

all subtrees are binary search tree

if we have duplicates, we can add a parameter "count" in the TreeNode

### functions
n节点数量，logn 树的高度
- add   time complexity: o(logn)

- remove  time complexity: o(logn)
1. 叶子
直接删就行
2. 有一个child
4种情况：被删在左在右，被删的child在左在右，经分析都可以直接用child代替这个节点
3. 有2个child
左子里面最大的，右子里面最小的，不一定是leaf

- find  time complexity: o(logn)

用recursion耗费空间，不断调用函数放到栈里，可以用while写


## 红黑树
Red-Black Tree, R-B tree
a balanced binary search tree



## Trie

### 时间复杂度

- 如果一个word的长度为l，trie的时间复杂度为O(l)

- 如果是二分查找，长度为l的单词最多可能有26^l^个，一般情况下肯定是多于2^l^个，所以时间复杂度一般大于O(log 2^l^) =  O(l)；





## Ternary Search Tree

是如何存储一个单词的？
