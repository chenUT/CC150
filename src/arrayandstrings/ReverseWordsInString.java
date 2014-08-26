package arrayandstrings;

public class ReverseWordsInString {
	public static void main(String[] args)
	{
		System.out.println(reverseWords("hello world, i love programming!"));
		
	}
	
	static String reverseWords(String str)
	{
		String tempStr = reverseString(str);
		String result = new String();
		int start=0,end=0;
		
		while(end<tempStr.length()+1)
		{
			if(end!=tempStr.length() && tempStr.charAt(end)!=' ')
			{
				end++;
			}
			else
			{
				result += reverseString(tempStr.substring(start, end))+" ";
				end++;
				start=end;
			}
		}
		
		return result;
	}
	
	static String reverseString(String str)
	{
		int start=0,end=str.length()-1;
		String result = str;
		while(start<end)
		{
			result = reverseChar(result, start, end);
			start++;
			end--;
		}
		
		return result;
	}
	
	static String reverseChar(String str, int start, int end)
	{
		char[] tempCharArray = str.toCharArray();
		char tempChar = tempCharArray[start];
		tempCharArray[start] = tempCharArray[end];
		tempCharArray[end] = tempChar;
		
		return new String(tempCharArray);
		
	}
	
	
}
