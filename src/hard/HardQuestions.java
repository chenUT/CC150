package hard;

public class HardQuestions {

	public static void main(String[] args){
		int a = 15;
		int b = 9;
//		System.out.println(a+" + "+b +" = "+addNum(a, b));
		System.out.println(countTwo(200));
		int target =593429567;
		long t = System.currentTimeMillis();
		int count1 = numOfTwos(target);
		long t2 = System.currentTimeMillis();
		t2 = t2-t;
		System.out.println("slow is "+ t2);
		t = System.currentTimeMillis();
		int count2 = numOfTwosRec(target);
		t2 = System.currentTimeMillis();
		t2 = t2-t;
		System.out.println("fast is "+ t2);
		System.out.println(count1 == count2);
		System.out.println(count1);
		System.out.print(count2);
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
	
	static int numOfTwosRec(int num){
		if(num == 0 ) return 0;
		
		int power =1 ;
		while(10*power < num) power *=10;
		
		int first = num/power;
		int reminder = num%power;
		
		int nTwoFirst = 0;
		if(first > 2){
			nTwoFirst += power;
		}
		else if(first == 2){
			nTwoFirst += reminder +1;
		}
		
		int nTwosOthers = first*numOfTwos(power-1) + numOfTwos(reminder);
		
		return nTwosOthers +nTwoFirst;
	}
	
	static int numOfTwos(int num){
		int totalTwo=0;
		if(num<2){
			return 0;
		}
		for(int i = 2 ; i <num+1; i++){
			totalTwo += countTwo(i);
		}
		return totalTwo;
	}
	
	static int countTwo(int num){
		int count = 0;
		int m = 1;
		int n = 1;
		int temp = (num%m)/n;
		int digits =1;
		while(10* m <num) {
			m*=10;
			++digits;
		}
		int i =0;
		m=10;
		while( i < digits){
			if(temp == 2){
				++count;
			}
			m *=10;
			n *=10;
			temp = (num%m)/n;
			++i;
		}
		return count;
	}
}
