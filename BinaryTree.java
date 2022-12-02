
public class BinaryTree {

	public Node root;
	
	public static class Node {
		public Node left;
		public Node right;
		public Object value;

		public Node(Object value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	//In order to delete a node from a BST, you need to put it in order first, have a search function, then a delete function, in that order.
	//You make min = the root value, and compare the min to the value of the node to its left. You compare and move down the tree until its the lowest value in the tree, and continue from there.
	public static int inOrder(Node root) {
		int min = (int) root.value;
        while(root.left != null) {
            min = (int) root.left.value;
            root = root.left;
        }
        return min;
    }
    //If the value = your target value, then you get your value, otherwise, it will compare nodes with each other, and based off of that, will move left or right.
    public static boolean search(Node root, int value) {
    	while(root != null) {
            if((int) root.value == value)
                return true;
            if(value < (int) root.value)
                root = root.left;
            else
                root = root.right;
        }
        return false;
    }
    //You have a value and you compare it to the root to see which way you will take down the tree. You then find your value you want to delete and replace it with its child.  
    public static Node delete(Node root, int value) {
    	if(root == null)
            return root;
    	if(value > (int) root.value) {
            root.right = delete(root.right, value);
        } if(value < (int) root.value) {
            root.left = delete(root.left, value);
        } else {
        	if(root.right == null) {
        		return root.left;
            } if(root.left == null)
                return root.right;
            root.value = inOrder(root.right);
            root.right = delete(root.right, (int) root.value);
        }
        return root;
    }
    //Creation of the tree, plus adding all of the values.
    public static void main(String[] args) {
    	BinaryTree tree = new BinaryTree();
    	tree.root = new Node(5);
		tree.root.left = new Node(3);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(4);
		tree.root.right = new Node(6);
		tree.root.right.right = new Node(7);
		
		inOrder(tree.root);
		delete(tree.root, 3);
		System.out.println("Is 3 still in the tree? " + search(tree.root, 3));
    }
}
