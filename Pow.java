package leetcode;
public class Pow {

	public double pow(double x, int n) {
		if (n == 0)
			return 1.0;
		double half = pow(x, n / 2);
		if (n % 2 == 0)
			return half * half;
		else if (n > 0)
			return half * half * x;
		else
			return half * half / x;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Pow().pow(2, -1);
	}

}
