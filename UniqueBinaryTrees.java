package leetcode;
public class UniqueBinaryTrees {
	int[][] v;

	public int numTrees(int n) {
		v = new int[n + 2][n + 2];
		for (int i = 0; i < n + 2; i++) {
			v[i][i] = 1;
		}
		return getNumbersOfTrees(1, n);
	}

	private int getNumbersOfTrees(int start, int end) {
		if (start >= end) {
			return 1;
		}
		int left = 0, right = 0;
		int sum = 0;
		for (int i = start; i <= end; i++) {
			if (v[start][i - 1] == 0)
				v[start][i - 1] = getNumbersOfTrees(start, i - 1);
			left = v[start][i - 1];
			if (v[i + 1][end] == 0)
				v[i + 1][end] = getNumbersOfTrees(i + 1, end);
			right = v[i + 1][end];
			sum += left * right;
		}
		v[start][end] = sum;
		return sum;
	}
}
