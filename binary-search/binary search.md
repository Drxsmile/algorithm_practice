# binary search
time complexity: o(logn)
search in a sorted array
compare target value to the middle element of the array
- upperbound
mid = (left + right) / 2;
left = mid +1;
right = mid;
- lowerbound
mid = (left + right + 1) / 2;
left = mid;
right = mid - 1;

## search input position
存在：返回index
不存在：返回比tar大的index，就是插入的index
在区间缩小的过程中，最后一定是左右先相邻然后重合才返回，希望重合落在右侧，所以left = mid+1，那mid = (left + right) / 2

