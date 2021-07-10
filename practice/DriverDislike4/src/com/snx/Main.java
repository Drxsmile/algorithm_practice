package com.snx;
/*
程序员小张打了一辆网约车出去玩，出于职业敏感，他注意到这辆网约车的计价计费偏大。
司机解释说他不喜欢数字4，所以改装了计价器，任何数字位置遇到数字4就直接跳过，其余功能都正常。

比如：

23再多一块钱就变为25；
39再多一块钱变为50；
399再多一块钱变为500；
请你帮小张通过计价器的表面读数，计算真实费用。

输入描述: 只有一行，数字N，表示里程表的读数。(1<=N<=6666666666)。

输出描述: 一个数字，表示实际产生的费用。以回车结束。
————————————————
版权声明：本文为CSDN博主「清风Python」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/BreezePython/article/details/117439252
 */
/*
示例1：
输入：5
输出：4
说明：5表示计价器的表面读数。
4表示实际产生的费用其实只有4块钱。

示例2：
输入：17
输出：15
说明：17表示计价器的表面读数。
15表示实际产生的费用其实只有15块钱。

示例3：
输入：100
输出：81
说明：100表示计价器的表面读数。
81表示实际产生的费用其实只有81块钱。
————————————————
版权声明：本文为CSDN博主「清风Python」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/BreezePython/article/details/117439252
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        int n = 100;
        int ans = n;
        int temp = 0;
        int k = 0;
        int j = 1;
        while(n > 0){
            int cur = n % 10;
            if(cur > 4){
                temp += j + (cur - 1) * k;
            }else {
                temp += cur * k;
            }
            k = k * 9 + j;
            j *= 10;
            n /= 10;
        }
        System.out.println(ans - temp);
    }
}
