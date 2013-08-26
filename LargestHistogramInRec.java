package leetcode;
public class LargestHistogramInRec {
	public int largestRectangleArea(int[] height) {
		int[] area = new int[height.length];
		for (int i = 0; i < height.length; i++) {
			if (i - 1 > 0 && height[i] == height[i - 1]) {
				area[i] = area[i - 1];
				continue;
			}
			int j = i, k = i;
			while (j >= 0 && height[j] >= height[i])
				j--;
			while (k < height.length && height[k] >= height[i])
				k++;
			area[i] = height[i] * (k - j - 1);
		}
		int max = 0;
		for (int i = 0; i < area.length; i++) {
			if (area[i] > max) {
				max = area[i];
			}
		}
		return max;
	}
}
