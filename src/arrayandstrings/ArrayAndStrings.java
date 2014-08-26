package arrayandstrings;

import java.util.ArrayList;

public class ArrayAndStrings {
	public static void main(String[] args) throws Exception{
		String test = "test";
		System.out.printf("%s\n", reverse(test));
		System.out.printf("%s\n", removeDuplicate(test));
		String abab ="ababababababa";
		System.out.printf("%s\n", removeDuplicate(abab));
		
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotateNinety(matrix);
		
		for(int i=0; i < matrix.length; ++i){
			for(int j =0; j<matrix.length; ++j){
				System.out.print(matrix[i][j]+" ");
			}
			//line break
			System.out.println();
		}
		System.out.println();
		
		int[][] matrix2 = {{1,2,3,4},{5,6,0,8},{9,10,11,12},{13,10,15,16}};
		for(int i=0; i < matrix2.length; ++i){
			for(int j =0; j<matrix2.length; ++j){
				System.out.print(matrix2[i][j]+" ");
			}
			//line break
			System.out.println();
		}
		System.out.println();
		
		zeroMatrix(matrix2);
		
		for(int i=0; i < matrix2.length; ++i){
			for(int j =0; j<matrix2.length; ++j){
				System.out.print(matrix2[i][j]+" ");
			}
			//line break
			System.out.println();
		}
		
		String a = "apple";
		String b= "pplea";
		String c="pplae";
		
		if(checkRotation(a, b)){
			System.out.printf("%s is rotation of %s\n",b,a);
		}
		else{
			System.out.printf("%s is not rotation of %s\n",b,a);
		}

        if(checkRotation(a, c)){
			System.out.printf("%s is rotation of %s\n",c,a);
		}
		else{
			System.out.printf("%s is not rotation of %s\n",c,a);
		}
	}
	
	static String reverse(String in){
		if(in == null)
			return "";
		 
		if(in.length()<2)
			return in;

		int start=0;
		int end = in.length()-1;
		
		char cache;
		char[] charArray = in.toCharArray();
		while(start<end && end >0){
			cache = charArray[start];
			charArray[start] = charArray[end];
			charArray[end]= cache;
			++start;
			--end;
		}
		
		return new String(charArray);
	}
	
	/**
	 * O(N^2) algorithm
	 * O(N-M) space where M is the number of duplicates
	 * if we want a inline algorithm we will need to remove the duplicate char once we find it
	 * @param in
	 * @return
	 */
	static String removeDuplicate(String in){
		if(in == null)
			return "";
		if(in.length()<2)
			return in;

		char[] charArray = in.toCharArray();
		StringBuffer resultString = new StringBuffer();
		char currChar;
		boolean found;
		for(int i = 0; i <in.length() ; i++){
			found=false;
			currChar = charArray[i];
			for(int j=(i+1); j<in.length(); j++){
				if(currChar == charArray[j]){
					found=true;
					break;
				}
			}
			if(!found){
				resultString.append(charArray[i]);
			}
		}
		return resultString.toString();
	}
	
	/**
	 * this method rotate the input matrix by 90 degrees and output the new one
	 * incoming matric is a N*N matrix
	 * @param in
	 * 			input matrix, it must be a square matrix
	 * @return rotate in for 90 degree clock wise
	 * @throws Exception when input matrix is not square
	 */
	static void rotateNinety(int[][] in) throws Exception{ 
		int rowCount = in.length;
		if(rowCount == 0){
			return ;
		}
		int colCount = in[0].length;
		if(colCount != rowCount){
			throw new Exception("Input must be square matrix");
		}
		
		//n here is the matrix size for convenience 
		int n = rowCount;
		int first, last;
		int top, offset;
		for(int layer =0; layer<n/2; ++layer){
			first = layer;
			last = n - layer -1 ;
			for(int i = first; i <last ; ++i){
				offset = i-first;
				
				//store the top one
				top = in[first][i];
				
				//put left bottom to top
				in[first][i] = in[last-offset][first];
				
				//put right bottom to left bottom
				in[last-offset][first] = in[last][last-offset];
				
				//put right top to right bottom
				in[last][last-offset] = in[i][last];
				
				//put top to right top
				in[i][last] = top;
			}
		}
	}
	
	/**
	 * 
	 * @param in
	 */
	static void zeroMatrix(int in[][]){
		
		int row = in.length;
		if(row ==0){ 
			return;
		}
		
		int col = in[0].length;
		if(col==0){
			return;
		}

		ArrayList<Integer> zeroRows = new ArrayList<>();
		ArrayList<Integer> zeroCols = new ArrayList<>();
		//first loop find zero row and col
		for(int i=0; i<row;++i){
			for(int j=0; j<col; ++j){
				if(in[i][j]==0){
					zeroRows.add(i);
					zeroCols.add(j);
				}
			}
		}
		
		//second loop zero out the rows and cols
		for(Integer zRow : zeroRows){
			zeroRow(zRow, in);
		}

        for(Integer zCol : zeroCols){
			zeroCol(zCol, in);
		}
	}
	
	static void zeroRow(int row, int[][] matrix){
		for(int i =0 ; i <matrix[row].length; ++i){
			matrix[row][i]=0;
		}
	}
	
	static void zeroCol(int col, int[][] matrix){
		for(int i = 0; i< matrix.length ; ++i){
			matrix[i][col]=0;
		}
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 */
	static boolean checkRotation(String a, String b){
		if(a.length() != b.length())
			return false;
		
		String concat = a+a;
		if(concat.contains(b)){
			return true;
		}
		else{
			return false;
		}
	}
	
}
