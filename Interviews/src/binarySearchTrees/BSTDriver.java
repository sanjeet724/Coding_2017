package binarySearchTrees;

class BSTDriver {

	public static void main(String[] args) {
		/*
		Node root = new Node(49);
		root.insert(79);
		root.insert(46);
		root.insert(41);
		root.insert(64);
		root.insert(89);
		root.insert(17);
		root.insert(42);
		root.insert(48);
		root.insert(47);
		root.insert(82);
		root.insert(90);
		// find something
		root.contains(78);
		root.contains(89);
		// print inorder
		// System.out.println("Printing in-order traversal :");
		// root.printInOrder();
		// print pre-order
		// System.out.println("Printing pre-order traversal : ");
		// root.printPreOrder();
		// print post-order
		 System.out.println("Printing post-order traversal : ");
		 root.printPostOrder();
		 */
		 testCase_1();
	}
	
	// no right sub-tree
	public static void testCase_1() {
		int [] inputs =  {33, 30, 45, 40, 46, 47, 48};
		Node bst = new Node(49); // create the root node
		for (int i : inputs) {
			bst.insert(i);
		}
		bst.printInOrder();
	}
}
