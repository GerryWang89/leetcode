package leetcode;

public class DistinctSubsequece {
	public int numDistinct(String S, String T) {
        int[][] v = new int[S.length()+1][T.length()+1];
        for(int i = 0; i <= S.length(); i++){
        	v[i][0] = 1;
        }
        for(int i = 1; i <= S.length(); i++){
        	for(int j = 1; j <= T.length(); j++){
        		v[i][j] = v[i-1][j];
        		if(S.charAt(i-1) == T.charAt(j-1)){
        			v[i][j] +=v[i-1][j-1];
        		}
        	}
        }
        return v[S.length()][T.length()];
    }
	
	public int numDistinct2(String S, String T) {
        int[] v = new int[T.length()+1];
    	v[0] = 1;
        for(int i = 1; i <= S.length(); i++){
        	for(int j = T.length(); j > 0; j--){
        		if(S.charAt(i-1) == T.charAt(j-1)){
        			v[j] +=v[j-1];
        		}
        	}
        }
        return v[T.length()];
    }
	
	public static void main(String[] args){
		System.out.println(new DistinctSubsequece().numDistinct("abccccd","acd")+"");
	}
}
