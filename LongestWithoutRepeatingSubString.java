package leetcode;
import java.util.ArrayList;
import java.util.List;

public class LongestWithoutRepeatingSubString {
	public int lengthOfLongestSubstring(String s) {
		int p = 0, q = 0;
		List<Character> ret = new ArrayList<Character>();
		int max = 0;
        while(p < s.length() && q < s.length()){
        	if(p == q){
        		q ++;
        		ret.add(s.charAt(p));
        		continue;
        	}else{
        		if(!ret.contains(s.charAt(q))){
        			ret.add(s.charAt(q));
        			q++;
        		}else{
        			max = ret.size()>max?ret.size():max;
        			p = p+ret.indexOf(s.charAt(q))+1;
        			q = p;
        			ret.clear();
        		}
        	}
        }
        max = ret.size()>max?ret.size():max;
        return max;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LongestWithoutRepeatingSubString().lengthOfLongestSubstring("abcabcaa");
	}
}