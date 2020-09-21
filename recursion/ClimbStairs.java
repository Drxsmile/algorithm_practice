class ClimbStairs{
	public static void main(String[] args){
		int stair = 5;
		climb(stair, "");


	}
	public static void climb(int n, String pre){
		//base case
		if(n == 1) System.out.println(pre+"1 ");
		else if(n == 2){
			System.out.println(pre + "1 1 ");
			System.out.println(pre + "2 ");
		}
		//recursion
		else{
			climb(n-1, pre + "1 ");
			climb(n-2, pre + "2 ");
		}
	}
	
}