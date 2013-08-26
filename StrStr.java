package leetcode;
/*
 * I didn't unterstand what to return in leetcode.
 * So I wrote a KMP.
 */
public class StrStr {
	public int strStr(String haystack, String needle) {
		int[] m = getPrefixFunction(needle);
		int q = 0;
		for(int i = 0; i < haystack.length(); i++){
			while (q > 0 && haystack.charAt(i) != needle.charAt(q)) {
				q = m[q] - 1;
			}
			if(haystack.charAt(i) == needle.charAt(q)){
				q++;
			}
			if (q == needle.length()) {
				return i - needle.length() + 1;
			}
		}
		return -1;
    }
	
	private int[] getPrefixFunction(String s){
		char[] p = s.toCharArray();
		int[] m = new int[s.length()];
		p[0] = 0;
		int k = 0;
		for(int i = 1; i < p.length; i++){
			while( k > 0 && p[k] != p[i])
				k = p[k]-1;
			if(p[i] == p[k]){
				k++;
			}
			m[i] = k;
		}
		return m;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new StrStr().strStr("abcrd","cr"));
	}

}
