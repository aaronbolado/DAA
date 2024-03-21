package MP1;

import java.util.Scanner;

public class BinaryTree {
    static Scanner input = new Scanner(System.in);
    TreeNode root; // Root of the binary tree
    int numElements; // Number of elements in the tree

    public BinaryTree() {
        this.root = null;
        this.numElements = 0;
    }

    // Method to create a new empty binary tree
    public void createBinaryTree() {
        if (root != null) {
            System.out.println("Error: Binary Tree already exists.");
            return;
        }
        root = null;
        numElements = 0;
        System.out.println("Created a new empty binary tree.");
    }

    // Method to insert an element into the binary tree
    public void insertElement() {
        System.out.print("Enter an Element to Insert: ");
        int element = input.nextInt();
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
        if (root == null) {
            System.out.println("Error: Binary Tree is Empty.");
            return;
        }

        System.out.print("Enter an Element to Delete: ");
        int element = input.nextInt();
        TreeNode[] parentAndNode = findParentAndNode(root, null, element);

        if (parentAndNode[1] == null) {
            System.out.println("Error: Element not found in Binary Tree.");
            return;
        }

        deleteHelper(parentAndNode[0], parentAndNode[1], element);
        numElements--;
        System.out.println("Element Deleted Successfully");
    }

    // Helper method to recursively delete an element from the binary tree
    private void deleteHelper(TreeNode parent, TreeNode current, int element) {
        if (current == null) {
            return;
        }

        if (element < current.data) {
            deleteHelper(current, current.left, element);
        } else if (element > current.data) {
            deleteHelper(current, current.right, element);
        } else {
            // Case 1: No child or 1 child
            if (current.left == null) {
                if (parent.left == current) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
                current = null;
            } else if (current.right == null) {
                if (parent.left == current) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
                current = null;
            }
            // Case 2: 2 children
            else {
                TreeNode successor = getSuccessor(current.right);
                current.data = successor.data;
                deleteHelper(current.right, successor, successor.data);
            }
        }
    }

    // Helper method to find the successor node in the binary tree
    private TreeNode getSuccessor(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
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

    // Method to search for an element in the binary tree
    public void searchElement() {
        if (root == null) {
            System.out.println("Error: Binary Tree is Empty.");
            return;
        }

        System.out.print("Enter an Element to Search: ");
        int element = input.nextInt();
        if (searchHelper(root, element)) {
            System.out.println("Element Found in Binary Tree");
        } else {
            System.out.println("Element Not Found in Binary Tree");
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
        if (root == null) {
            System.out.println("Binary Tree is Empty");
            return;
        }

        System.out.println("Binary Tree Elements (Breadth-first Traversal):");
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

    // Method to display the structure of the binary tree (Parent Nodes, Leaf Nodes, and Level)
    public void displayTreeStructure() {
        if (root == null) {
            System.out.println("Binary Tree is Empty");
            return;
        }

        System.out.println("--- Binary Tree Structure ---");
        displayStructureHelper(root, 0);
    }

    // Helper method to recursively display the structure of the binary tree
    private void displayStructureHelper(TreeNode current, int level) {
        if (current == null) {
            return;
        }

        // Display the current node
        System.out.println("Level " + level + ": " + current.data);

        // Recur for left and right subtrees with increased level
        displayStructureHelper(current.left, level + 1);
        displayStructureHelper(current.right, level + 1);
    }
}