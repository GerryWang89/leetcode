package leetcode;

public class RemoveDuplicateFromSortedArray {

	public int removeDuplicates(int[] A) {
        for(int i = 0; i < A.length-1; i++){
            if(A[i] == A[i+1])
                A[i] = -255;
        }
        int count = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != -255){
                
                A[count] = A[i];
                count++;
            }
        }
        return count;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = new int[]{1};
		System.out.println(new RemoveDuplicateFromSortedArray().removeDuplicates(a));
	}

}
