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
//		
//		System.out.println("min:"+s.min());
//		System.out.println("pop:"+s.pop());
//		System.out.println("min:"+s.min());
//		System.out.println("pop:"+s.pop());
//		System.out.println("min:"+s.min());
//		System.out.println("pop:"+s.pop());
//		System.out.println("min:"+s.min());
//		System.out.println("pop:"+s.pop());
//		System.out.println("min:"+s.min());
//		System.out.println("pop:"+s.pop());
		
//		SizedStack ss = new SizedStack(4);
//		
//		for(int i =0; i < 4 ; i++){
//			System.out.println("push: "+i);
//			ss.push(i);
//		}
//		System.out.println("stack is full: "+ss.isFull());
//
//		System.out.println("pop: "+ss.pop());
//		System.out.println("pop: "+ss.pop());
//		System.out.println("pop: "+ss.pop());
//		System.out.println("pop: "+ss.pop());
//		
//		System.out.println("stack is empty: "+ss.isEmpty());
//
//		
		SetOfStacks sos = new SetOfStacks();
		
		int counter = 14;
		for(int i =0; i < counter ; i++){
			System.out.println("push: "+i);
			sos.push(i);
		}
		
		for(int i = 0 ; i < counter ; i++){
			System.out.println("pop: "+sos.pop());
		}
		
	}
}

class SetOfStacks{
	ArrayList<SizedStack> stacks;
	
	public SetOfStacks(){
		stacks = new ArrayList<>();
		/* we add the first stack*/
		stacks.add(new SizedStack(4));
	}
	
	public void push(int data){
		if(stacks.get(stacks.size()-1).isFull()){
			SizedStack newStack = new SizedStack(4);
			newStack.push(data);
			stacks.add(newStack);
		}
		else{
			stacks.get(stacks.size()-1).push(data);
		}
	}
	
	public int pop(){
		int result =  stacks.get(stacks.size()-1).pop();
		if(stacks.get(stacks.size()-1).isEmpty()){
			if(stacks.size() != 1){ 
				stacks.remove(stacks.size()-1);
			}
		}
		return result;
	}
}

class SizedStack{
	int []datas;
	int index;
	public SizedStack(int size){
		index = -1;
		datas = new int[size];
	}
	
	public void push(int data){
		//if stack is full this will throw a index out of bound exception
		datas[++index] = data;
	}
	
	public int pop(){
		return datas[index--];
	}
	
	public boolean isEmpty(){
		return index==-1;
	}
	
	public boolean isFull(){
		return index == datas.length-1;
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
