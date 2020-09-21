class Hanoi{
	public static void main(String[] args){
		int n = 3;
		path(n, 'A', 'C', 'B');
	}
	public static void path(int n, char src, char des, char spare){
		if(n == 1){
			System.out.println("Move " + src + " to " + des);
		}
		else{
			path(n-1, src, spare, des);
			System.out.println("Move " + src + " to " + des);
			path(n-1, spare, des, src);
		}
	}
}