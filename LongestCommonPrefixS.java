package leetcode;

public class LongestCommonPrefixS {

	public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return myLongest(strs,strs.length);        
    }
    
    private String myLongest(String[] strs, int length){
        if(length == 0)
            return "";
        if(length == 1)
            return strs[0];
        strs[length-2] = find(strs[length-2],strs[length-1]);
        return myLongest(strs,length-1);
    }
    
    private String find(String s1,String s2){
        int i = 0;
        for(i = 0; i < Math.min(s1.length(),s2.length());i++){
            if( s1.charAt(i) != s2.charAt(i)){
                return s1.substring(0,i);
            }
        }
        if(i == Math.min(s1.length(),s2.length())){
            return s1.substring(0,i);
        }
        return "";
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}
