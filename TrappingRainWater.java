package leetcode;

public class TrappingRainWater {

	public int trap(int[] A) {
        if(A.length < 2){
            return 0;
        }
        int[] A2 = new int[A.length+2];
        int[] c = new int[A2.length];
        System.arraycopy(A,0,A2,1,A.length);
        for(int i = 1; i < c.length-1; i++){
            if(A2[i] > c[i-1]){
                c[i] = A2[i];
            }else{
                c[i] = c[i-1];
            }
        }
        for(int i = c.length-2; i > 0; i--){
            if(A2[i] >= c[i+1]){
                c[i] = A2[i];
            }else{
                c[i] = Math.min(c[i-1],c[i+1]);
                if(c[i] < A2[i]){
                	c[i] = A2[i];
                }
            }
        }
        int ret = 0;
        for(int i = 1; i < c.length-1; i++){
            ret += (c[i] - A2[i]);
        }
        return ret;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new TrappingRainWater().trap(new int[]{1,5,7}));
	}

}
