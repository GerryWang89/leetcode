package leetcode;

public class Atoi {

	public int atoi(String str) {
		if(str.equals("")){
            return 0;
        }
        str = str.trim();
        int ret=0;
        boolean positive = true;
        int start = 0, end = 0;
        for(int i =0; i < str.length(); i++,start=i){
        	if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
        		str = str.substring(i);
        		break;
        	}else if(str.charAt(i) == '-'){
        		str = str.substring(i+1);
        		positive = false;
        		break;
        	}else if(str.charAt(i) == '+'){
        		str = str.substring(i+1);
        		break;
        	}
        }
        if(start == str.length()){
        	return 0;
        }
        for(int i =0; i < str.length(); i++,end=i){
        	if(str.charAt(i) < '0' || str.charAt(i) > '9'){
        		break;
        	}
        }
        if( positive && str.length() >= 10 && str.compareTo(Integer.MAX_VALUE+"")>0){
            return Integer.MAX_VALUE;
        }
        if( !positive && str.length() >= 10 && str.compareTo((Integer.MIN_VALUE+"").substring(1))>0){
            return Integer.MIN_VALUE;
        }
        for(int i = 0; i<str.length(); i++){
        	if(str.charAt(i) > '9' || str.charAt(i) < '0'){
        		if(!positive){
                    ret *= -1;
                }
        		return ret;
        	}
            ret = ret*10+str.charAt(i)-'0';
        }
        if(!positive){
            ret *= -1;
        }
        return ret;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Atoi().atoi("         -1019955o7298"));
	}

}
