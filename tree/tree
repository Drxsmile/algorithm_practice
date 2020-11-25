# tree
## binary tree
1. traversal
- dfs
preOrder
inOrder
postOrder

- bfs
levelOrder
[leetcode link](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

why use queue?How does the queue keep order?
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

如果需要分层呢？
**solution 1**
上一层和下一层分别放入两个队列

**solution 2**
上一层和下一层之间放一个null

**solution 3**
对每层计数 count = queue.size()

**solution 4**
dfs
