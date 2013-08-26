package leetcode;

public class RemoveElement {

	public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i = 0; i < A.length; i++){
            if(A[i] == elem)
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
		// TODO Auto-generated method stub

	}

}
