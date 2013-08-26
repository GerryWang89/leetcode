package leetcode;

public class LongestPalindrmic {

	//¶¯Ì¬¹æ»®n^2
	public String longestPalindrome(String s) {
		int[][] w = new int[s.length()][s.length()];
		int start = 0,end = 0;
		int max = 0;
		for(int i = 0; i < s.length(); i++){
			w[i][i] = 1;
		}
		for(int i = 1; i < s.length(); i++){
			for(int j = 0; j < s.length(); j++){
				if(j+i >= s.length()){
					break;
				}
				if(i == 1 && s.charAt(j+i) == s.charAt(j)){
					w[j][j+i] = 1;
					if(i + 1 > max){
						max = i + 1;
						start = j;
						end = j+i;
					}
				}else if(i != 1 && s.charAt(j+i) == s.charAt(j)){
					if(w[j+1][j+i-1] == 1){
						w[j][j+i] = 1;
						if(i + 1 > max){
							max = i + 1;
							start = j;
							end = j+i;
						}
					}
				}else if(s.charAt(j+i) != s.charAt(j)){
					w[j][j+i] = 0;
				}
			}
		}
		for(int i = 0; i < s.length(); i++){
			for(int j = i; j < s.length(); j++){
				System.out.print(w[i][j]+" ");
				if(w[i][j] == 1 && j - i + 1> max){
					start = i;
					end = j;
					max = j-i+1;
				}
			}
			System.out.println();
		}
        return s.substring(start, end+1);
    }
	
	//manacher
	public String manacher(String s){
		for(int i = 0; i < s.length(); i+=2){
			s = s.substring(0,i) + "#" + s.substring(i);
		}
		s = s+"#";
		int id = 0;
		int max = 0;
		int[] p = new int[s.length()];
		p[0] = 1;
		for(int i = 1; i < s.length(); i++){
			if(max > i){
				p[i] = Math.min(p[id*2-i],max-i);
			}else{
				p[i] = 1;
			}
			while( i-p[i] >= 0 && i+p[i] < s.length() && s.charAt(i+p[i]) == s.charAt(i-p[i])){
				p[i]++;
			}
			if(p[i] + i - 1 > max){
				max =p[i] + i - 1;
				id = i;
			}
		}
		id = 0; 
		max = 0;
		for(int i = 0; i < p.length; i++){
			if(p[i] > max){
				max = p[i];
				id = i;
			}
		}
		return s.substring(id-p[id]+1,id+p[id]).replace("#","");		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new LongestPalindrmic().manacher("ccd"));
	}

}
