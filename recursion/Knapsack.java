class Knapsack{
	public static void main(String[] args) {
		int s = 20;
		int[] wgt = {14, 9, 7, 5, 3} ;
		//boolean flag = find(s, wgt, 0);
		boolean flag = srch(s, wgt, 0);
		System.out.println(flag);

	}
	public static boolean find(int s, int[] wgt, int index){
		boolean f = false;
		//base case
		if(s == 0) return true;
		if(s < 0) return false;
		if(index == wgt.length -1){
			f = (s == wgt[index]) ? true : false;
		}
		//recursion
		else if(find(s-wgt[index], wgt, index+1)||find(s, wgt, index+1))
			f = true;
		return f;
	}

	public static boolean srch(int s, int[] wgt, int index){
		if(s == 0) return true; //the pack is full
		if(s<0 || index >= wgt.length) return false;
		// the pack is overload or the pack is not full but all wgts have been tried
		return srch(s-wgt[index], wgt, index+1)||srch(s, wgt, index+1);
	}
	
}