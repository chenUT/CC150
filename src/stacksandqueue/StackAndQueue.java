package stacksandqueue;

import java.util.ArrayList;
import java.util.Stack;

public class StackAndQueue {
	public static void main(String[] args){

		MinStack s = new MinStack(16);
		
		s.push(5);
		s.push(3);
		s.push(4);
		s.push(2);
		s.push(6);
		
		System.out.println("min:"+s.min());
		System.out.println("pop:"+s.pop());
		System.out.println("min:"+s.min());
		System.out.println("pop:"+s.pop());
		System.out.println("min:"+s.min());
		System.out.println("pop:"+s.pop());
		System.out.println("min:"+s.min());
		System.out.println("pop:"+s.pop());
		System.out.println("min:"+s.min());
		System.out.println("pop:"+s.pop());
	}
}

class SetOfStack{
	ArrayList<Stack> stacks;
	
	public SetOfStack(){
		stacks = new ArrayList<>();
	}
	
	
}

class MinStack{

	Node []datas;
	int index;
	int currMin;

	public MinStack(int size){
		datas = new Node[size];
		index = 0;
		currMin = Integer.MAX_VALUE;
	}
	
	public void push(int data){
		Node newNode = new Node();
		newNode.data = data;
		if(currMin>data){
			currMin = data;
		}
		newNode.min = currMin;
		datas[index] = newNode;
		index++;
	}
	
	public int pop(){
		--index;
		if(index == 0){
			currMin = Integer.MAX_VALUE;
		}
		else{
			currMin = datas[index-1].min;
		}
		int result = datas[index].data;
		return result;
	}

	public int min(){
		return datas[index-1].min;
	}
	
}

class Node{
	int data;
	int min;
}
