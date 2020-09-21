class Hanno{
	public static void main(String[] args) {
		int n = 3;
		move(n,"A", "B", "C");

	}
	public static void move(int x, String src, String spare, String des){
		if(x == 1){
			System.out.println("Move "+ src+ " to " + des);
			return;
		}
		else{
			move(x-1, src, des, spare);
			System.out.println("Move "+ src+ " to " + des);
			move(x-1, spare, src, des);
		}
	}
}