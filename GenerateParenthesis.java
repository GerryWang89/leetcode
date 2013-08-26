package leetcode;
import java.util.ArrayList;
import java.util.List;


public class GenerateParenthesis {
	private ArrayList<String> ret;
	
	public ArrayList<String> generateParenthesis(int n) {
		ret = new ArrayList<String>();
		find("",n,n);
		return ret;
    }
    
    public void find( String s, int left, int right ){
    	if(right < left || left < 0 || right < 0 ){
    		return;
    	}
        if(left == 0 && right == 0){
            ret.add(s);
    	}		
        else{
            find(s+"(",left-1,right);
            find(s+")",left,right-1);
        }
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GenerateParenthesis().generateParenthesis(3);
	}
}