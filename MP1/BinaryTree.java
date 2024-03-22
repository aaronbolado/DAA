package MP1;

import java.util.Scanner;

public class BinaryTree {
    static Scanner input = new Scanner(System.in);
    InputChecker inputChecker = new InputChecker(input);

    TreeNode root; // Root node of tree
    int numElements; // Number of elements in the tree

    public BinaryTree() {
        this.root = null;
        this.numElements = -1; // Indicates No Binary Tree
    }

    // Method to create a new empty binary tree
    public void createBinaryTree() {
        if (numElements >= 0) { 
            System.out.println("Error: A Binary Tree already exists.");
            return;
        }

        root = null;
        numElements = 0;
        System.out.println("Created a new empty binary tree.");
    }

    // Method to insert an element into the binary tree
    public void insertElement() {
        if (numElements == -1) {
            System.out.println("Error: Binary Tree Does Not Exist. Create a Binary Tree.");
            return;
        }

        System.out.print("Enter an Element to Insert: ");
        int element = inputChecker.getIntInput();
        
        if (searchHelper(root, element) == true) {
            System.out.println("Error: Please avoid entering duplicates for binary trees.");   
            return;         
        }

        TreeNode newNode = new TreeNode(element);

        if (root == null) {
            root = newNode;
            numElements++;
            System.out.println("Element Inserted Successfully");
            return;
        }

        insertHelper(root, newNode);
        numElements++;
        System.out.println("Element Inserted Successfully");
    }

    // Helper method to recursively insert an element into the binary tree
    private void insertHelper(TreeNode current, TreeNode newNode) {
        if (newNode.data < current.data) {
            if (current.left == null) {
                current.left = newNode;
            
            } else {
                insertHelper(current.left, newNode);
            }

        } else {
            if (current.right == null) {
                current.right = newNode;
            
            } else {
                insertHelper(current.right, newNode);
            }
        }
    }

    // Method to delete an element from the binary tree
    public void deleteElement() {
        if (numElements == -1) {
            System.out.println("Error: Binary Tree Does Not Exist. Create a Binary Tree.");
            return;
        }

        if (root == null) {
            System.out.println("Error: Binary Tree is Empty.");
            return;
        }

        System.out.print("Enter an Element to Delete: ");
        int element = inputChecker.getIntInput();

        TreeNode[] parentAndNode = findParentAndNode(root, null, element);

        if (parentAndNode[1] == null) {
            System.out.println("Error: Element not found in Binary Tree.");
            return;
        }

        parentAndNode[0] = deleteHelper(parentAndNode[0], element);
        numElements--;
        System.out.println("Element Deleted Successfully");
    }

    // Helper method to recursively delete an element from the binary tree
    private TreeNode deleteHelper(TreeNode current, int element) {
        if (current == null) {
            return current;
        }

        // Traversing the tree
        if (element < current.data) {
            current.left = deleteHelper(current.left, element);
        } else if (element > current.data) {
            current.right = deleteHelper(current.right, element);

        } else { // Element found 
            // Node with only one child or no child
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            // Node with two children
            current.data = minValue(current.right);
            current.right = deleteHelper(current.right, current.data); // Deletes the lower switched node
        }
        return current;
    }

    private int minValue(TreeNode node) {
        int minv = node.data;
        while (node.left != null) {
            minv = node.left.data;
            node = node.left;
        }
        return minv;
    }

    // Helper method to find the parent and node containing the given element
    private TreeNode[] findParentAndNode(TreeNode current, TreeNode parent, int element) {
        if (current == null) {
            return new TreeNode[]{parent, null};
        }

        if (current.data == element) {
            return new TreeNode[]{parent, current};
        }

        if (element < current.data) {
            return findParentAndNode(current.left, current, element);
        } else {
            return findParentAndNode(current.right, current, element);
        }
    }

    // Helper method to recursively search for an element in the binary tree
    private boolean searchHelper(TreeNode current, int element) {
        if (current == null) {
            return false;
        }

        if (element == current.data) {
            return true;
        } else if (element < current.data) {
            return searchHelper(current.left, element);
        } else {
            return searchHelper(current.right, element);
        }
    }

    // Method to display the elements in the binary tree (in-order traversal)
    public void displayBinaryTree() {
        if (numElements == -1) {
            System.out.println("Error: Binary Tree Does Not Exist. Create a Binary Tree.");
            return;
        }

        if (root == null) {
            System.out.println("Binary Tree is Empty");
            return;
        }

        System.out.println("Binary Tree Elements: ");
        int height = getHeight(root);

        for (int level = 1; level <= height; level++) {
            printGivenLevel(root, level);
            System.out.println();
        }
    }

    // Get the height of the binary tree
    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // Print nodes at a given level
    private void printGivenLevel(TreeNode node, int level) {
        if (node == null) {
            System.out.print("null ");
            return;
        }
        if (level == 1) {
            System.out.print(node.data + " ");
        } else if (level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }

    // Method to display the structure of the binary tree
    public void displayTreeStructure() {
        if (numElements == -1) {
            System.out.println("Error: Binary Tree Does Not Exist. Create a Binary Tree.");
            return;
        }

        if (root == null) {
            System.out.println("Binary Tree is Empty");
            return;
        }

        System.out.println("Binary Tree Structure: ");
        System.out.print("Parent Nodes: ");
        displayParentNodes(root);
        System.out.print("\nLeaf Nodes: ");
        displayLeafNodes(root);
        System.out.println("\nLevel: " + getHeight(root));
    }

    // Method to recursively display parent nodes
    private void displayParentNodes(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null || node.right != null) {
            System.out.print(node.data + ", ");
        }
        displayParentNodes(node.left);
        displayParentNodes(node.right);
    }

    // Method to recursively display leaf nodes
    private void displayLeafNodes(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.print(node.data + ", ");
        }
        displayLeafNodes(node.left);
        displayLeafNodes(node.right);
    }
}