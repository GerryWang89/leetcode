package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CombineSumII {

	private ArrayList<ArrayList<Integer>> ret;
    private ArrayList<Integer> cur;
    private HashSet<Integer> hash;
    
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
    	if(candidates == null){
    		return null;
    	}
    	Arrays.sort(candidates);
		ret = new ArrayList<ArrayList<Integer>>();
		cur = new ArrayList<Integer>();
		find(0,0,candidates,target);
		return ret;
    }
    
    private void find( int sum, int index, int[] candidates, int target ){
    	if(index >= candidates.length){
    		return;
    	}
    	cur.add(candidates[index]);
    	sum+=candidates[index];
    	if(sum == target){
    		ArrayList<Integer> ans = new ArrayList<Integer>(cur);
    		ret.add(ans);
            cur.remove(cur.size()-1);
    		return;
    	}
    	if(sum > target){
    		cur.remove(cur.size()-1);
    		return;
    	}
    	find(sum,index+1,candidates,target);
    	cur.remove(cur.size()-1);
    	sum-=candidates[index];
    	int j = index+1;
    	while(j<candidates.length && candidates[j] == candidates[j-1]){
    		j++;
    	}
    	find(sum,index+1,candidates,target);
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
