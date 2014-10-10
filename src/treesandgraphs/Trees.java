package treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Trees {
	
	public static void main(String[] args){
		Node a = new Node(1,"a");
		Node a1 = new Node(2,"a1");
		Node a2 = new Node(2,"a2");
		Node a3 = new Node(3,"a3");
		Node a4 = new Node(2,"a4");
		Node a5 = new Node(2,"a5");
		Node a6= new Node(1,"a6");
		Node a7 = new Node(2,"a7");
		Node a8 = new Node(3,"a8");
		Node a9 = new Node(1,"a9");
		Node a10 = new Node(1,"a10");
		Node a11 = new Node(2,"a11");
		
		a.left = a1;
		a.right = a3;
		a1.left = a2;
		a3.left = a4;
		a1.right = a5;
		a2.left = a6;
		a2.right = a7;
		a3.right = a8;
		a4.left = a9;
		a4.right = a10;
		a9.left = a11;
		
		long time = System.nanoTime();
		findSum(a, 3, new ArrayList<Integer>(), 0);
		long time2 = System.nanoTime() - time;
		System.out.println("timer1:  "+time2);
		time = System.nanoTime();
		printPath(3, a);
		time2 = System.nanoTime() - time;
		System.out.println("timer2:  "+time2);
	}
	
	//level order travsel
	static ArrayList<LinkedList<Node>> linkedListForAllLevels(Node t){
		ArrayList<LinkedList<Node>> result  = new ArrayList<LinkedList<Node>>();
		return null;
	}

	static PNode findNextNodeInOrder(PNode n){
		if(n != null){
			if(n.parent == null || n.right != null){
				return findLeftMostChile(n.right);
			}
			else{
				if( n.parent.left.value == n.value){
					return n.parent;
				}
				else{
					PNode p;
					while((p = n.parent) != null){
						if(p.left.value == n.value){
							break;
						}
						n = p;
					}
					return p;
				}
			}
		}
		return null;
	}
	
	
	static PNode findLeftMostChile(PNode n){
		if( n == null) return n;
		while(n.left != null) n = n.left;
		return n;
	}
	
	static Node findCommonAncestor(Node tree, Node n1, Node n2){
		//null means false
		if(tree == null){
			return null;
		}
		//both on same side we keep searching
		else if(hasNode(tree.left, n1) && hasNode(tree.left, n2)){
			return findCommonAncestor(tree.left, n1, n2);
		}
		else if(hasNode(tree.right, n1) && hasNode(tree.right, n2)){
			return findCommonAncestor(tree.right, n1, n2);
		}
		//both on different side we find the solution
		else{
			return tree;
		}
	}

	static boolean hasNode(Node tree, Node n){
		//reach the end do not find
		if(tree == null)
			return false;
		
		if(tree.value == n.value)
			return true;
		
		return hasNode(tree.left, n) || hasNode(tree.right, n);
	}
	
	static boolean isSubTree(Node bigTree, Node smallTree){
		//if bigTree reaches null return false
		if(bigTree == null)
			return false;
		//compare root value
		if(bigTree.value == smallTree.value){
			if(matchTree(bigTree, smallTree)) 
				return true;
//			if(smallTree.left == null && smallTree.right == null){
//				return true;
//			}
//			if(smallTree.left == null){
//				return isSubTree(bigTree.right, smallTree.right);
//			}
//			else if(smallTree.right == null){
//				return isSubTree(bigTree.left, smallTree.left);
//			}
//			else{
//				return isSubTree(bigTree.left, smallTree.left) && isSubTree(bigTree.right, smallTree.right);
//			}
		}
		return isSubTree(bigTree.left, smallTree) || isSubTree(bigTree.right, smallTree);
	}
	
	static boolean matchTree(Node t1, Node t2){
		if(t2 == null) //finish search in small tree return true
			return true;
		
		if(t1 == null) //big tree empty still not found then its false
			return false;
		
		if(t1.value == t2.value)
			return matchTree(t1.left, t2.left) 
					&& matchTree(t1.left, t2.left);
		else
			return false;
	}
	
	/*the "correct" answer, is it faster ? i dont think so....*/
	static void findSum(Node tree, int sum, ArrayList<Integer> buffer, int level){
		if(tree == null) return;
		int tmp = sum;
		buffer.add(tree.value);
		for(int i = level ; i>-1; --i){
			tmp -= buffer.get(i);
			if(tmp == 0) printTrack(buffer, i, level);
		}
		ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
		
		findSum(tree.left, sum, c1, level+1);
		findSum(tree.right, sum, c2, level+1);
	}
	
	static void printTrack(ArrayList<Integer> buffer, int level, int i2){
		for( int i = level; i <=i2; i++){
			System.out.print(buffer.get(i)+" ");
		}
		
		System.out.println();
	}
	
	/*
	 * another implementation for findSum
	 * call printPath(target, root) to begin
	 * slower? 
	 * this is a modified version of pre-order search
	 */
	static void printPath(int target, Node tree){
		if(tree != null){
			printPathRec(target, 0, tree,"");
			printPath(target, tree.left);
			printPath(target, tree.right);
		}
	}
	
	static void printPathRec(int target, int sum, Node curr, String path){
		if(curr == null){
			return;
		}
		if(path.length() == 0){
			path = curr.name+"("+curr.value+")";
		}
		else{
			path =path+"->"+curr.name+"("+curr.value+")";
		}
		sum = curr.value+sum;
		if(sum == target){
			System.out.println(path);
		}
		//becuase value can be negative
		printPathRec(target, sum, curr.left, path);
		printPathRec(target, sum, curr.right, path);
	}
}

class PNode{
	int value;
	String name;
	PNode parent;
	PNode left;
	PNode right;

	public PNode(int a, String name){
		this.value = a; 
		this.name = name;
	}
}

class Node{
	int value;
	String name;
	Node left;
	Node right;
	
	public Node(int a,String name){
		this.value =a;
		this.name = name;
	}
}