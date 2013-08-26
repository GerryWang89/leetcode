package leetcode;
import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {
	private ArrayList<ArrayList<Integer>> ret;
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ret = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i < num.length; i++){
			nums.add(num[i]);
		}
//		for (int i = 0; i < num.length; i++) {
//			nums.add(num[i]);
//			if (i < num.length - 1 && num[i] == num[i + 1]) {
//				nums.add(num[i]);
//				while(i < num.length - 1 && num[i] == num[i+1]){
//					i++;
//				}
//			}
//		}
		nums.add(Integer.MAX_VALUE);
		getSubsets(nums, 0, new ArrayList<Integer>());
		return ret;
	}
	
	private void getSubsets(ArrayList<Integer> nums, int index, ArrayList<Integer> cur){
		for(int i = index; i < nums.size(); i++){
			if(nums.get(i) == Integer.MAX_VALUE){
				ret.add(new ArrayList<Integer>(cur));
				return;
			}
			cur.add(nums.get(i));
			getSubsets(nums,i+1,cur);
			cur.remove(cur.size()-1);
			int val = nums.get(i);
			while(i < nums.size() && nums.get(i) == val){
				i++;
			}
			i--;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new SubsetsII().subsetsWithDup(new int[]{1,2,2,2,3}));
	}

}
