package hard;

public class HardQuestions {

	public static void main(String[] args){
		int a = 15;
		int b = 9;
		System.out.println(a+" + "+b +" = "+addNum(a, b));
	}
	
	public static int addNum(int a, int b){
		if(b==0) return a;
		int sum = a ^ b;
		int carry = (a&b)<<1;
		return addNum(sum, carry);
	}
	
	static String[] perfectShuffle(String[] cards){
		String[] shuffled = new String[cards.length];
		
		/*sort it*/
		
		/* pick one card from deck using random number generator
		 * swap it with first card, then keep picking until reach the end*/
		
		return shuffled;
	}
	
	static int rand(int low, int high){
		return (int)(Math.random()*(high-low+1));
	}
	
	static void swap(int[] numbers, int first, int second){
		int temp = numbers[first];
		numbers[first] = numbers[second];
		numbers[second] = temp;
	}
	
	/**
	 * 
	 * @param count
	 * 			assume count smaller then numbers.length
	 * @param numbers
	 * @return
	 */
	static int[] randSub(int count, int[] numbers){
		int[] results = new int[count];
		int[] clone = numbers.clone();
		int first, pickIndex;
		for(int i = 0 ; i < count; i++){
			pickIndex = rand(i, clone.length-1);
			results[i] = clone[pickIndex];
			//we dont have to swap if we are using a cloned buffer
//			swap(clone, i, pickIndex);
			clone[pickIndex] = clone[i];
		}
		return results;
	}
}
