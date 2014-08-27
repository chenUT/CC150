package stacksandqueue;

import java.util.ArrayList;
import java.util.Stack;

public class StackAndQueue {
	public static void main(String[] args) throws Exception{

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

//		SetOfStacks sos = new SetOfStacks();
//		
//		int counter = 14;
//		for(int i =0; i < counter ; i++){
//			System.out.println("push: "+i);
//			sos.push(i);
//		}
//		
//		for(int i = 0 ; i < counter ; i++){
//			System.out.println("pop: "+sos.pop());
//		}
		StackT s1 = new StackT();
		StackT s2 = new StackT();
		StackT s3 = new StackT();
		for(int i =4 ; i >0 ; i--){
//			System.out.println("pushing: "+i);
			s1.push(new NodeH(i));
		}
		towerOfHanoi(s1, s2, s3);
		
		for(int i = 0; i < 4; i++){
			System.out.println(s3.pop().size);
		}
	}
	
	/**
	 * 
	 * @param n number of  
	 * @param s1
	 * @param s2
	 * @param s3
	 * @throws Exception 
	 */
	public static void towerOfHanoi( StackT s1, StackT s2, StackT s3) throws Exception{
		int n = s1.size();
		//first move top n-1 to s2
		moveTopNToSecond(n-1, s1, s2, s3);
//		System.out.println("moving "+s1.peek().size +" to s3");
		s3.push(s1.pop());
		moveTopNToSecond(n-1, s2, s3, s1);
	}

	public static void moveTopNToSecond(int n, StackT s1, StackT s2,  StackT s3) throws Exception{
		if(n==2){
//			System.out.println("moving last two");
			s3.push(s1.pop());
			s2.push(s1.pop());
			s2.push(s3.pop());
		}
		else{
			moveTopNToSecond(n-1, s1, s3, s2);
//			System.out.println("moving "+s1.peek().size +" to s2");
			s2.push(s1.pop());
			moveTopNToSecond(n-1, s3, s2, s1);
		}
	}
	
	public static void move(Stack<NodeH> s1, Stack<NodeH> s2){
		s2.push(s1.pop());
	}
}

class StackT{
	private Stack<NodeH> stack;
	public StackT(){
		stack = new Stack<NodeH>();
	}
	
	public NodeH pop(){
		return stack.pop();
	}
	
	public void push(NodeH n) throws Exception{
		if(stack.isEmpty()){
			stack.push(n);
		}
		else{
			NodeH t = stack.peek();
			if(t.size < n.size){
				throw new Exception("mush push smaller size!");
			}
			else{
				stack.push(n);
			}
		}
	}
	
	public NodeH peek(){
		return stack.peek();
	}
	
	public int size(){
		return stack.size();
	}
}

class NodeH{
	int size;
	public NodeH(int d){
		this.size = d;
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
