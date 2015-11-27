import java.util.*;
class BinarySearchTreeNode {
	BinarySearchTreeNode left;
	BinarySearchTreeNode right;
	int height;
	int data;
	public BinarySearchTreeNode(BinarySearchTreeNode left,int data,BinarySearchTreeNode right) {
		this.left = left;
		this.right = right;
		this.data = data;
	}
	public void setLeft(BinarySearchTreeNode left) {
		this.left = left;
	}
	public BinarySearchTreeNode getLeft() {
		return left;
	}
	public void setRight(BinarySearchTreeNode right) {
		this.right = right;
	}
	public BinarySearchTreeNode getRight() {
		return right;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
}
class BinarySearchTreeArrayList {
	BinarySearchTreeNode root;
	public void BinarySearchTreeArrayList(){
		root = null;
	}
	public void insert(int value) {
		BinarySearchTreeNode parent = null;
		root = insert(root,parent,value);
	}
	public BinarySearchTreeNode singleRotationLeft(BinarySearchTreeNode root5) {
		BinarySearchTreeNode temp5 = root5.getLeft();
		// System.out.println("root: "+ root5.getData());
		// System.out.println("temp: "+ temp5.getData());
		root5.setLeft(temp5.getRight());
		temp5.setRight(root5);
		root5.height = max(FindHeight(root5.getLeft()),FindHeight(root5.getRight())) + 1;
		temp5.height = max(FindHeight(temp5.getLeft()),FindHeight(temp5.getRight())) + 1;
		return temp5;	
	}
	public BinarySearchTreeNode singleRotationRight(BinarySearchTreeNode root5) {
		BinarySearchTreeNode temp5 = root5.getRight();
		System.out.println("root: "+ root5.getData());
		System.out.println("temp: "+ temp5.getData());
		System.out.println("temp->right" + temp5.getRight().getData());
		root5.setRight(temp5.getLeft());
		temp5.setLeft(root5);
		root5.height = max(FindHeight(root5.getLeft()),FindHeight(root5.getRight())) + 1;
		temp5.height = max(FindHeight(temp5.getLeft()),FindHeight(temp5.getRight())) + 1;
		return temp5;
	}
	public BinarySearchTreeNode leftRightRotation(BinarySearchTreeNode root5) {
		root5.setLeft(singleRotationRight(root5.getLeft()));
		return singleRotationLeft(root5);
	}
	public BinarySearchTreeNode rightLeftRotation(BinarySearchTreeNode root5) {
		root5.setRight(singleRotationLeft(root5.getRight()));
		return singleRotationRight(root5);
	}
	public BinarySearchTreeNode insert(BinarySearchTreeNode root2,BinarySearchTreeNode parent,int value) {
		if( root2 == null) {
			BinarySearchTreeNode temp = new BinarySearchTreeNode(null,value,null);
			root2 = temp;
			root2.height = 0;
		}
		else if(value < root2.getData()){
			root2.setLeft(insert(root2.getLeft(),root2,value));
			if((FindHeight(root2.getLeft()) - FindHeight(root2.getRight())) == 2) {
				if(value < root2.getLeft().getData()) {
					System.out.println("SingleRotateLeft");
					root2 = singleRotationLeft(root2);
				}
				else {
					System.out.println("LeftRightRotation");
					root2 = leftRightRotation(root2);
				}
			}
		}
		else if(value > root2.getData()) {
			root2.setRight(insert(root2.getRight(),root2,value));
			if((FindHeight(root2.getRight()) - FindHeight(root2.getLeft())) == 2) {
				if(value < root2.getRight().getData()) {
					System.out.println("RightLeftRotation");
					root2 = rightLeftRotation(root2);
				}
				else {
					System.out.println("SingleRightRotation");
					root2 = singleRotationRight(root2);
				}
			}
		}
		root2.height = max(FindHeight(root2.getLeft()), FindHeight(root2.getRight()));
		return root2;
	}
	public int max(int a, int b) {
		if(a < b) {
			return b;
		}
		else {
			return b;
		}
	}
	public void remove(int element) {
		root = removeElement(root,element);
		balanceTree(root);
		root.height = max(FindHeight(root.getLeft()), FindHeight(root.getRight()));
	}
	public void balanceTree(BinarySearchTreeNode root1) {
		if(!isBalanced(root1)) {
			// System.out.println("*************");
			// System.out.println(FindHeight(root1.getRight()));
			// System.out.println(FindHeight(root1.getLeft()));
			if((FindHeight(root1.getRight()) - FindHeight(root1.getLeft())) == 2) {
				//System.out.println("####################");
				if(root1.getRight().getLeft() == null) {
					System.out.println("SingleRightRotation");
					root1 = singleRotationRight(root1);
				}
				else {
					System.out.println("RightLeftRotation");
					root1 = rightLeftRotation(root1);
				}
			}
			else if((FindHeight(root1.getLeft()) - FindHeight(root1.getRight())) == 2) {
				if(root1.getLeft().getLeft() == null) {
					System.out.println("LeftRightRotation");
					root1 = leftRightRotation(root1);
				}
				else {
					System.out.println("SingleRotateLeft");
					root1 = singleRotationLeft(root1);
				}
			}
		}
	}
	public boolean isBalanced(BinarySearchTreeNode root6) {
		if((FindHeight(root6.getRight()) - FindHeight(root6.getLeft())) >= 2 || (FindHeight(root6.getRight()) - FindHeight(root6.getLeft())) <= -2) {
			//System.out.println("Tree is not Balanced");a
			return false;
		}
		else {
			//System.out.println("Tree is Balanced");
			return true;
		}
	}
	public BinarySearchTreeNode removeElement(BinarySearchTreeNode root2,int element) {
		if(root2 == null) {
		}
		else if(element < root2.getData()) {
			root2.setLeft(removeElement(root2.getLeft(),element));
		}
		else if(element > root2.getData()) {
			root2.setRight(removeElement(root2.getRight(),element));
		}
		else {
			BinarySearchTreeNode temp;
			if(root2.getLeft() == null && root2.getRight() == null) {
				root2 = null;
			}
			else if(root2.getLeft() != null && root2.getRight() != null) {
				temp = getMax(root2.getLeft());
				root2.setData(temp.getData());
				root2.setLeft(removeElement(root2.getLeft(),root2.getData()));
			}
			else {
				temp = root2;
				if(root2.getLeft() == null) {
					root2 = root2.getRight();
				}
				if(root2.getRight() == null ) {
					temp = getMax(root2.getLeft());
					if(temp != null) {
						root2.setData(temp.getData());
						root2.setLeft(removeElement(root2.getLeft(),root2.getData()));
					}
				}
			}
		}
		if(root2 != null){
			root2.height = max(FindHeight(root2.getLeft()), FindHeight(root2.getRight()));
			balanceTree(root2);
		}
		return root2;
	}
	public int FindHeight(BinarySearchTreeNode root3) {
		if(root3 == null) {
			return 0;
		}
		int leftHeight = FindHeight(root3.getLeft());
		int rightHeight = FindHeight(root3.getRight());
		if(leftHeight > rightHeight) {
			return leftHeight + 1;
		}
		else {
			return rightHeight + 1;
		}
	}
	
	public BinarySearchTreeNode getMax(BinarySearchTreeNode root3) {
		if(root3 == null) {
			return null;
		}
		else {
			while(root3.getRight() != null) {
				root3 = root3.getRight();
			}
			return root3;
		}
	}
	public void printBinarySearchTreeInorder() {
		printInorder(root);
		System.out.println();
	}
	public void printBinarySearchTreePostorder() {
		if(root == null) {
			System.out.println("0");
		}
		else {
			printPostorder(root);
			System.out.println();
		}
	}
	public void printPostorder(BinarySearchTreeNode temp3) {
		if(temp3 != null) {
			printPostorder(temp3.getLeft());
			printPostorder(temp3.getRight());
			System.out.print(temp3.getData() + ",");
		}
	}
	public void printInorder(BinarySearchTreeNode temp3) {
		if(temp3 != null) {
			printInorder(temp3.getLeft());
			System.out.print(temp3.getData() + ",");
			printInorder(temp3.getRight());
		}
	}
}
public class AVLRemove {
	public static void main(String[] args) {
		BinarySearchTreeArrayList bst = new BinarySearchTreeArrayList();
		Scanner input = new Scanner(System.in);
		int flag = 1;
		while(flag == 1) {
			String string = input.nextLine();
			String[] str = string.split(" ");
			if(str[0].compareTo("insert") == 0) {
				bst.insert(Integer.parseInt(str[1]));
				bst.printBinarySearchTreeInorder();
				bst.printBinarySearchTreePostorder();
			}
			else if(str[0].compareTo("remove") == 0) {
				bst.remove(Integer.parseInt(str[1]));
				bst.printBinarySearchTreeInorder();
				bst.printBinarySearchTreePostorder();
			}
			else if(str[0].compareTo("end") == 0) {
				flag = 0;
			}
		}
		bst.printBinarySearchTreeInorder();
		bst.printBinarySearchTreePostorder();
	}
}