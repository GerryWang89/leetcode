package leetcode;

public class MergeSortedArray {

	public void merge(int A[], int m, int B[], int n) {
        if(m == 0){
            for(int i = 0; i < n; i++){
                A[i] = B[i];
            }
            return;
        }
        if(n == 0){
            return;
        }
        int indexA = m - 1;
        int indexB = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (A[indexA] >= B[indexB]) {
                A[i] = A[indexA];
                indexA--;
            }else{
                A[i] = B[indexB];
                indexB--;
            }
            if(indexA == -1){
                for(int j = indexB; j >= 0; j--){
                    A[j] = B[j];
                }
                return;
            }
            if(indexB == -1){
                return;
            }
        }
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MergeSortedArray().merge(new int[]{1,3,4,0,0}, 1, new int[]{2,3}, 1);
	}

}
