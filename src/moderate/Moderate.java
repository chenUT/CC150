package moderate;

import java.util.Random;

public class Moderate {
	public static void main(String[] args){
//		testBigNumberNoCompare(4, 5);
//		testBigNumberNoCompare(6, 5);
		System.out.println(numZeros(16));
//		
	}
	
	static int rand7(){
		int num = 7 * (rand5()-1) ;
		while(true){
			if(num > 21){
				num = 5 * (rand5()-1) + (rand5() - 1);
			}
			else{
				return num % 7+1; 
			}
		}
	}
	
	static int rand5(){
		Random r = new Random();
		return r.nextInt(4)+1;
	}
	
	static void printEncodeXML(String str){
		
	}
	
	static long fac(long n){
		if(n == 0){
			return 1;
		}
		else 
			return n * fac(n-1);
	}
	
	static int numZeros(int num){
		int count =0;
		if(num < 0 ){
			System.out.println("Factorial is not defined for < 0");
            return 0;
		}
		else{
			for(int i = 5 ;  num/i >0; i = i*5){
				count += num/i;
			}
		}
		return count;
	}
	
	static void testBigNumberNoCompare(int a, int b){
		System.out.println("between "+a+" and "+b+" , "+bigNumberNoCompare(a, b)+" is bigger");
	}
	
	static int bigNumberNoCompare(int a , int b){
		int c = a - b;
		int k = (c>>31) & 0x01;
		return a - c*k;
	}
}
