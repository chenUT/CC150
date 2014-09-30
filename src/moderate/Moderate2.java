package moderate;


public class Moderate2 {
	public static void main(String[] args){
		
	}
	
	public static int largestSum(int[] nums){
		int max = Integer.MIN_VALUE;
		int sum =0 ;
		for(int i = 0 ; i < nums.length ; i++){
			sum += nums[i];
			if(max < sum){
				max = sum;
			}
			else if(sum < 0 ){
				sum =0;
			}
		}
		return max;
	}
}
