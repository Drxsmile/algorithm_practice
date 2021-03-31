# Graph
## what is graph
点：vertices / nodes   
边：
- undirected graph
edges

- directed graph
arrows / directed edges   
强连通：任意2点可以互相有路径到达

## Graph Representation
1. adjacent matrices  
比较占空间，适合密集的图   
if there are n vertices, we use a n * n matrix to store 0s and 1s which stand for edges' existing

| index |   0   |   1   |   2   |
| :---: | :---: | :---: | :---: |
|   0   |   1   |   1   |   0   |
|   1   |   1   |   1   |   1   |
|   2   |   0   |   1   |   1   |

2. adjacent lines     
适合稀疏的图，每个node存储的是
List<neighbors的index>     

| vertices | List<Integer> |
| :------: | :-----------: |
|    0     |      {1}      |
|    1     |    {0, 2}     |
|    2     |      {1}      |



3. graph node

## Topological sort
1. 有向无环图 DAG(Directed Acyclic Graph)  
不能顺着方向形成环的图

2. Topological sort     
- 只有DAG才能拓扑排序
- 每次找到没有入边的node输出
- 然后把这些node的出边删除
- 循环



## 做题步骤

1. 构建临接表（和degree表），先把点+空的list加进去
2. 遍历边，填充临接表（+ degree表）
3. bfs遍历 + topological sort



