package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		HashMap<String,Integer> map = new HashMap<String,Integer>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++){
            for(int j=i-1,k=i+1;j >= 0 && k < num.length;){
                if(num[i]+num[j]+num[k] < 0){
                    k++;
                }else if(num[i]+num[j]+num[k] > 0){
                    j--;
                }else{
                    ArrayList<Integer> cur = new ArrayList<Integer>();
                    cur.add(num[i]);
                    cur.add(num[j]);
                    cur.add(num[k]);
                    Collections.sort(cur);
                    if(!map.containsKey(cur.get(0)+" "+cur.get(1)+" "+cur.get(2))){
                        ret.add(cur);
                        map.put(cur.get(0)+" "+cur.get(1)+" "+cur.get(2),1);
                    }
                    j--;
                }
            }
        }
        return ret;
    }
	
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
	}
}
