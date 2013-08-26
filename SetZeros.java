package leetcode;
public class SetZeros {
	public void setZeroes(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return;
		boolean firstLine = false;
		boolean firstRow = false;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				firstLine = true;
				break;
			}
		}
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				firstRow = true;
				break;
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < matrix[i].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int i = 1; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 1; j < matrix.length; j++) {
					matrix[j][i] = 0;
				}
			}
		}
		if (firstLine) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
		if (firstRow) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}
	}
	
	public static void main(String[] args){
		new SetZeros().setZeroes(new int[][]{{0},{1}});
	}
}
