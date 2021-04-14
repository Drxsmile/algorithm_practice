# UnionFind

## 特点

- union的共性特征保存在root上；

- 合并一次，就少了一个祖先（集合）；

- 希望树矮，所以小的合并到大的里；      
例子：1-2-3，4-5      
小指向大：2层      
大指向小：4层

- 解题过程
1. 初始化
2. union
3. find

## implements
### simple
```java
class UnionFind{
    List<Integer> list;
    UnionFind(int n){
        list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(i);
        }
    }
    public boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return false;
        list.set(rootB, rootA);
        return true;
    }
    public int find(int i){
        while(i != list.get(i)){
            i = list.get(i);
        }
        return i;
    }
}
```

### optimization with height
```java
class UnionFind{
    List<Integer> list;
    List<Integer> height;
    UnionFind(int n){
        list = new ArrayList<>();
        height = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(i);
            height.add(1);
        }
    }
    public boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return false;
        int heightA = height.get(rootA);
        int heightB = height.get(rootB);
        if(heightA > heightB){
            list.set(rootB, rootA);
        }else if(heightA == heightB){
            list.set(rootB, rootA);
            height.set(rootA, heightA + 1);
        }else{
            list.set(rootA, rootB);
        }
        return true;
    }
    public int find(int i){
        while(i != list.get(i)){
            i = list.get(i);
        }
        return i;
    }
}
```


