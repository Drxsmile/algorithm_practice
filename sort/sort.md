# sort

## O($n^2$)
1. bubble sort
- 每一轮相邻元素比较
- optimization      
(1)如果有一轮没有元素交换，说明排序完成     
(2)记录最后一次交换元素的位置，设置为下一次遍历的终点
- time complexity
best:
average:
worst:
- stability
stable
- in place

2. insertion sort
- 分为已排序和未排序2个区间
- 第一个元素为已排序，后面的元素依次插入到已排序的区间里   
- time complexity
best:
average:
worst:
- stability
stable
- in place

1. selection sort
- 分为已排序和未排序2个区间
- 在未排序的区间找到最小的，与区间交点交换，扩展已排序的区间  
- time complexity
best:
average:
worst:
- stability
unstable
- in place


## O($nlog^n$)

1. quick sort    
- worst: O($n^2$)
- average: O($nlog^n$)    
- 平均来说，树的高度是$log^n$；最坏退化成链表，高度为$n$；每一层处理时间都为O($n$)    


如果要保证O($nlog^n$)，用下面2种
2. merge sort

3. heap sort

   完全二叉树，用数组存储，利用父子节点的index关系

- 构造大根堆（从最后一个叶子节点的爸爸开始下沉排序）
- 把堆顶和数组最后一个数交换（堆顶弹出，堆size-1）
- 堆顶下沉排序

```java
public int[] sortArray(int[] nums) {
        //heapify
        for(int i = (nums.length - 2) / 2; i >= 0; i--){
            siftDown(nums, i, nums.length - 1);
        }
        // sort
        for(int i = nums.length - 1; i > 0; i--){
            swap(nums, i, 0);
            siftDown(nums, 0, i - 1);
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j){
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
    public void siftDown(int[] nums, int cur, int end){
        while(2 * cur + 1 <= end){// 有左宝宝
            if(2 * cur + 2 <= end){
                if(nums[2 * cur + 2] >= nums[2 * cur + 1] && nums[2 * cur + 2] > nums[cur]){
                    swap(nums, cur, 2 * cur + 2);
                    cur = 2 * cur + 2;
                }else if(nums[2 * cur + 2] < nums[2 * cur + 1] && nums[2 * cur + 1] > nums[cur]){
                    swap(nums, cur, 2 * cur + 1);
                    cur = 2 * cur + 1;
                }else return;
            }else{
                if(nums[2 * cur + 1] > nums[cur]){
                    swap(nums, cur, 2 * cur + 1);
                    cur = 2 * cur + 1;
                }else return;
            }

        }
    }
```



## O($n$)
1. bucket sort
2. count sort
3. radix sort

## Compare

1. 参数：Object o1, Object o2
2. 原理：按照权重升序排序，权重大的排在后面
- \>0前面权重大（排序后：o2, o1）
- <0后面权重大（排序后：o1, o2）
3. 常见应用场景之数字排序
- 数值升序   
```
// 给数值大的赋予大权重
if(o1 > o2) return 1;
if(o1 == o2) return 0;
if(o1 < o2) return -1;
```
等价简洁写法
`return o1 - o2;`

- 数值降序   
```
// 给数值小的赋予大权重
if(o1 > o2) return -1;
if(o1 == o2) return 0;
if(o1 < o2) return 1;
```
等价简洁写法
`return o2 - o1;`



## quick select

1. 2-way partition

pivot如果选在左边，注意记录nums[left]，不然换完值就变了，难怪用nums[right] 

// to do

[left, j) <= pivot

[j, right] > pivot

```java
public void partition(nums, left, right){
  	int j = left + 1;
		for(int i = left + 1; i <= right; i++){
			  if(nums[i] <= nums[right]){
      			swap(nums, i, j++);
    		}
		}
}
```



2. 3-way partition

```java
pu void quickSelect(int[] nums, int left, int right){
        // [left, less) < pivot
        // [less, more) == pivot
        // [more, right] > pivot
        int pivot = nums[left];
        int less = left;
        int more = less + 1;
        for(int i = left + 1; i <= right; i++){
            if(nums[i] < pivot){
                swap(nums, less, i);
                less++;
                swap(nums, more, i);
                more++;
            }else if(nums[i] == pivot){
                swap(nums, more, i);
                more++;
            }
        }
        int mid = (nums.length - 1) / 2;
        if(mid < less){
            quickSelect(nums, left, --less);
        }else if(mid >= more){
            quickSelect(nums, more, right);
        }
    }
```

迭代的话就while(true){

​	改端点的值

}