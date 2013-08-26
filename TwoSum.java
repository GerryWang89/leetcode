package leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TwoSum().twoSum(new int[]{150,24,79,50,88,345,3}, 200);
	}
	
	public int[] twoSum(int[] numbers, int target) {
        List<NumberHolder> nl = new ArrayList<NumberHolder>();
        for(int i = 0; i < numbers.length; i++){
            nl.add(new NumberHolder(i, numbers[i]));
        }
        Collections.sort(nl,new MyComparator());
        int i = 0, j = nl.size()-1;
        while(i < j){
            if(nl.get(i).value+nl.get(j).value == target){
            	if(nl.get(i).index < nl.get(j).index)
                    return new int[]{nl.get(i).index+1,nl.get(j).index+1};
                return new int[]{nl.get(j).index+1,nl.get(i).index+1};
            }else if(nl.get(i).value+nl.get(j).value < target){
                i++;
            }else{
                j--;
            }
        }
        return null;
    }
	class NumberHolder{
		public int index;
		public int value;
		public NumberHolder(int index, int value){
			this.index = index;
			this.value = value;
		}
	}
	
	class MyComparator implements Comparator<NumberHolder>{
		@Override
		public int compare(NumberHolder o1, NumberHolder o2) {
			if(o1.value < o2.value){
				return -1;
			}else if(o1.value > o2.value){
				return 1;
			}else{
				return 0;
			}
		}
		
	}
}
