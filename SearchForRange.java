package leetcode;

public class SearchForRange {
	public int[] searchRange(int[] A, int target) {
        if(target< A[0] || target>A[A.length-1]){
            return new int[]{-1,-1};
        }
        int[] range = search(A,0,A.length-1,target);
        int s =range[0],e=range[1];
        if(s == -1){
            return new int[]{-1,-1};
        }
        while(A[s]<target){
            s++;
        }
        while(A[e]>target){
            e--;
        }
        return new int[]{s,e};
    }
    
    public int[] search(int[] A, int s, int e, int target){
        if(s == e){
            if(target == A[s])
                return new int[]{s,e};
            else
                return new int[]{-1,-1};
        }
        if(A[(s+e)/2] == target){
            return new int[]{s,e};
        }else if(A[(s+e)/2] > target){
            return search(A,s,(s+e)/2,target);
        }else{
            return search(A,(s+e)/2+1,e,target);
        }
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
