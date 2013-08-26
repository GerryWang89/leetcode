package leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MedianofTwoArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new MedianofTwoArray().findMedianSortedArrays(new int[]{1}, new int[]{2,3}));
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
        if(A.length == 0){
            return find(B,0,B.length-1);
        }else if(B.length == 0){
            return find(A,0,A.length-1);
        }else{
            return find2(A,0,A.length-1,B,0,B.length-1);
        }
    }
    
    private double find2(int[] A, int sa, int ea, int[] B, int sb, int eb){
        if(ea-sa == 1 && sb == eb){
            List<Integer> nl = new ArrayList<Integer>();
            nl.add(A[sa]);
            nl.add(A[ea]);
            nl.add(B[sb]);
            Collections.sort(nl);
            return nl.get(1);
        }
        if(ea == sa && eb - sb == 1){
            List<Integer> nl = new ArrayList<Integer>();
            nl.add(A[sa]);
            nl.add(B[eb]);
            nl.add(B[sb]);
            Collections.sort(nl);
            return nl.get(1);
        }
        if(sa == ea && sb == eb){
            return (A[sa]+B[sb])/2.0;
        }
        double ma = find(A,sa,ea);
        double mb = find(B,sb,eb);
        if(ma == mb){
            return ma;
        }else if(ma < mb){
            return find2(A,(sa+ea+1)/2,ea,B,sb,(sb+eb)/2);
        }else{
            return find2(A,sa,(sa+ea)/2,B,(sb+eb+1)/2,eb);
        }
    }
    
    private double find(int[] A, int s, int e){
        return (A[(s+e)/2]+A[(s+e+1)/2])/2.0;
    }
}
