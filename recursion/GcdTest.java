class GcdTest{
	public static void main(String[] args){
		int a = 27;
		int b = 36;
		int c = gcd(a, b);
		System.out.println("greatest commen divisior : "+c);
	}
	public static int gcd(int x, int y){
		if(x<y){
			int t = x;
			x = y;
			y = t;
		}
		if(y == 0) return x;
		int mod = x % y;
		return gcd(mod, y);
	}
}