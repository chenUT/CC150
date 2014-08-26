package matrix;
import java.util.HashSet;
import java.util.Iterator;


public class MNMatrixZero {

	public static void main(String[] args)
	{
		int[][] matrix = {{1,0,3,4},{1,2,3,4},{3,5,6,0}};
		int[][] result = setMatrixToZeor(matrix);
		printMatrix(result);
	}
	
	static void printMatrix(int[][] matrix)
	{
		int rowNum =matrix.length;
		int colNum = matrix[0].length;
		
		for(int i =0;i<rowNum; i++)
		{
			for(int j=0;j<colNum; j++)
			{
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	static int[][] setMatrixToZeor(int[][]matrix)
	{
		HashSet<Integer> colZeros  = new HashSet<Integer>();
		HashSet<Integer> rowZeros = new HashSet<Integer>();
		
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		for(int i=0; i <rowNum ; i++)
		{
			for(int j=0; j <colNum ; j++)
			{
				if(matrix[i][j]==0)
				{
					colZeros.add(j);
					rowZeros.add(i);
				}
			}
		}
		
		Iterator itor = colZeros.iterator();
		int[][] result = matrix.clone();
		
		while(itor.hasNext())
		{
			result = setColZero(result, (Integer)itor.next());
		}
		
		itor  = rowZeros.iterator();
		while(itor.hasNext())
		{
			result = setRowZero(result, (Integer)itor.next());
		}
		
		return result;
			
	}
	
	static int[][] setRowZero(int[][] matrix, int row)
	{
		int colNums = matrix[row].length;
		for(int i= 0; i<colNums; i++)
		{
			matrix[row][i] = 0;
		}
		
		return matrix;
	}
	
	static int[][] setColZero(int[][] matrix, int col)
	{
		int rowNums = matrix.length;
		for(int i= 0; i<rowNums; i++)
		{
			matrix[i][col] = 0;
		}
		return matrix;
	}
	
}
