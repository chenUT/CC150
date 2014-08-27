package linkedlists;

import java.util.HashMap;

public class LinkedLists {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList mList = new LinkedList();
		mList.insert(new Node(1));
		mList.insert(new Node(3));
		mList.insert(new Node(2));
		mList.insert(new Node(3));
		mList.insert(new Node(4));
		//System.out.println("data: "+mList.findNthLastElement(2).data);
		//mList.printList();
	//	mList.removeDuplicateNS();
		//mList.removeDuplicateN();
		//mList.printList();
		
		LinkedList num1 = new LinkedList();
		num1.insert(new Node(1));
		num1.insert(new Node(6));
		num1.insert(new Node(6));
		num1.insert(new Node(6));
		
		LinkedList num2 = new LinkedList();
//		num2.insert(new Node(1));
//		num2.insert(new Node(6));
//		num2.insert(new Node(6));
//		
		System.out.println("num1: ");
		num1.printList();

		System.out.println("num2: ");
		num2.printList();

		addTwoNumber(num1, num2).printList();
	}
	
	static LinkedList addTwoNumber(LinkedList num1, LinkedList num2){
		LinkedList result = new LinkedList();
		Node n1 = num1.head;
		Node n2 = num2.head;
		
		if(null == n1){
			return num2;
		}
		
		if(null == n2){
			return num1;
		}
		int carry =0;
		Node currNode; 
		int value;
		while(n1 != null || n2 != null){
			currNode = new Node();
			value = 0 ;	
			if(n1 != null){
				value += n1.data;
			}
			if(n2 !=null){
				value += n2.data;
			}
			value += carry;
			//add data to current node
			currNode.data = value%10;

			//determine carry for next digit
			if(value > 9){
				carry = 1;
			}
			else{
				carry = 0;
			}
			
			result.insert(currNode);
			if(n1!=null){
				n1 = n1.next;
			}
			if(n2 != null){
				n2 = n2.next;
			}
		}
		if(carry ==1){
			result.insert(new Node(1));
		}
		return result;
	}

}



class LinkedList{
	Node head;
	public LinkedList(){
		head = null;
	}
	
	public void insert(Node node){
		if(head == null){
			head = node;
			head.next = null;
		}
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = node;
		node.next = null;
	}

	/**
	 * this is a N approach with a hashed map buffer
	 */
	public void removeDuplicateN(){
		HashMap<Integer, Boolean> cache = new HashMap<Integer, Boolean>();
		
		Node traversal = head;
		while(traversal != null){
			if(cache.containsKey(traversal.data)){
				if(traversal.next!=null){
					traversal.data = traversal.next.data;
					traversal.next = traversal.next.next;
				}
				else{
					traversal = null;
				}
			}
			else{
				cache.put(traversal.data, true);
			}
			traversal = traversal.next;
		}
	}
	
	/**
	 * this is a N^2 approach with out a hash buffer
	 */
	public void removeDuplicateNS(){
		Node traversal = head.next;

		if(traversal == null)
			return;

		Node checkNode = head;
		while(checkNode.next!=null){
			while(traversal!=null){
				if(traversal.data == checkNode.data){
					//remove traversal node
					if(traversal.next !=null){
						traversal.data = traversal.next.data;
						traversal.next = traversal.next.next;
					}
					else{
						traversal = null;
					}
				}
				traversal = traversal.next;
			}
			checkNode = checkNode.next;
			traversal = checkNode.next;
		}
	}
	/**
	 * 
	 * An algorithm to find the nth to last element of a singly linked list
	 * 
	 * @param n
	 * @return
	 */
	public Node findNthLastElement(int n){

		Node advance = head;
		Node target = head;

		for(int i=0 ; i < n ; ++i){
			if(advance.next != null){
				advance = advance.next;
			}
			else{
				return null;
			}
		}
		
		while(advance.next != null){
			target = target.next;
			advance = advance.next;
		}
		
		return target;
	}
	
	public void printList(){
		Node temp = head;
		System.out.println("-----list begin------");
		while(temp != null){
			System.out.printf("%d",temp.data);

			if(temp.next!= null)
				System.out.print("->");
			
			temp = temp.next;
		}
		System.out.println();
		System.out.println("-----list end------\n");
	}
}

class Node{
	Node next;
	int data;
	public Node(){
		next= null;
	}
	
	public Node(int data){
		this.data=data;
	}
}