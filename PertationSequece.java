package leetcode;
import java.util.ArrayList;
import java.util.Arrays;


public class PertationSequece {

	public String getPermutation(int n, int k) {
        int[] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = i+1;
        }
        ArrayList<ArrayList<Integer>> p = permute(num);
        ArrayList<Integer> temp = p.get((k-1)%p.size());
        String ret = "";
        for(int i = 0; i < temp.size(); i++){
            ret += temp.get(i);
        }
        return ret;
    }
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Arrays.sort(num);
		if(num.length == 1){
            temp.add(num[0]);  
            ret.add(temp);
            return ret;
        }
		for(int i = 0; i < num.length; i++){
			temp.add(num[i]);
		}
		ret.add(temp);
		while((temp = nextPermutation(num)) != null){
			ret.add(temp);
			System.out.println(temp+" ");
		}
		return ret;
    }
    
    private ArrayList<Integer> nextPermutation( int[] num ){
    	ArrayList<Integer> ret = new ArrayList<Integer>();
		int i = num.length-2,j = num.length-1, k=j;
		while(num[i] >= num[j]){
			i--;
			j--;
			if(i<0){
				return null;
			}
		}
		while(num[k] <= num[i]){
			k--;
		}
		int temp = num[k];
		num[k] = num[i];
		num[i] = temp;
		reverse(num,j,num.length-1);
		for(Integer item : num){
			ret.add(item);
		}
		return ret;
	}
	
	private void reverse(int[] num, int s, int e){
		for(;s<e;s++,e--){
			int temp = num[e];
			num[e] = num[s];
			num[s] = temp;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
