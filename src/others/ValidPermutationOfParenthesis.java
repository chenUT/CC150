package others;

public class ValidPermutationOfParenthesis {
	public static void main(String[] args)
	{
		allParenthesis(3, 0, "");
	}
	
	public static void allParenthesis(int open, int close, String result)
	{
		if(open ==0 && close ==0)
			System.out.println(result);
		else
		{
			if(open>0)
				allParenthesis(open-1, close+1, result+"<");
			
			if(close>0)
				allParenthesis(open, close-1, result+">");
		}
	}
}
