// Cooper Bartl
// CS145
// 3/12/2024

// This program is designed to be a dictionary of hypothetical users of a website.
// It functions as a Binary Search Tree (BST) with menu options to: add user, delete user,
// edit user and print BST in either in-order, post-order or pre-order.

import java.util.Scanner;

public class Dictionary {
    private TreeNode root;

    public Dictionary() {
        this.root = null;
    }

    // method for adding new member
    public void addMember(Member member) {
        root = insert(root, member);
        System.out.println("Member added successfully.");
    }

    // method for inserting new member into correct spot in bst
    private TreeNode insert(TreeNode root, Member member) {
        if (root == null) {
            return new TreeNode(member);
        }

        int compareResult = member.email.compareTo(root.data.email);

        if (compareResult < 0) {
            root.left = insert(root.left, member);
        } else if (compareResult > 0) {
            root.right = insert(root.right, member);
        } else {
            System.out.println("Member with the same email already exists. Cannot add.");
        }

        return root;
    }

    // method for deleting member
    public void deleteMember(String email) {
        root = delete(root, email);
    }

    // method for deleting member from TreeNode
    private TreeNode delete(TreeNode root, String email) {
        if (root == null) {
            return root;
        }

        int compareResult = email.compareTo(root.data.email);

        if (compareResult < 0) {
            root.left = delete(root.left, email);
        } else if (compareResult > 0) {
            root.right = delete(root.right, email);
        } else {
            // node with one or less childs
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // get the smallest value in the sub-tree
            root.data = minValue(root.right);

            // delete node
            root.right = delete(root.right, root.data.email);
        }

        return root;
    }
 
    // finds minimum value in subtree
    private Member minValue(TreeNode root) {
        Member minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // modifies existing member
    public void modifyMember(String email) {
        TreeNode node = search(root, email);

        if (node != null) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter new first name: ");
            node.data.firstName = scanner.nextLine();

            System.out.println("Enter new last name: ");
            node.data.lastName = scanner.nextLine();

            System.out.println("Enter new street address: ");
            node.data.streetAddress = scanner.nextLine();

            System.out.println("Enter new zip code: ");
            node.data.zipCode = scanner.nextLine();

            System.out.println("Enter new email: ");
            node.data.email = scanner.nextLine();

            System.out.println("Enter new phone number: ");
            node.data.phoneNumber = scanner.nextLine();

            System.out.println("Member modified successfully.");
        } else {
            System.out.println("Member with the specified email not found.");
        }
    }

    // displays tree in either pre-order, in-order or post-order
    public void displayTree(String order) {
        switch (order) {
            case "pre-order":
                preOrderTraversal(root);
                break;
            case "in-order":
                inOrderTraversal(root);
                break;
            case "post-order":
                postOrderTraversal(root);
                break;
            default:
                System.out.println("Invalid order specified.");
        }
    }

    // prints tree in pre-order 
    private void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.println("First Name:" + root.data.firstName);
            System.out.println("Last Name:" + root.data.lastName);
            System.out.println("Address:" + root.data.streetAddress);
            System.out.println("Zip Code:" + root.data.zipCode);
            System.out.println("Email:" + root.data.email);
            System.out.println("Number:" + root.data.phoneNumber);
            System.out.println();
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    // prints tree in in-order
    private void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println("First Name:" + root.data.firstName);
            System.out.println("Last Name:" + root.data.lastName);
            System.out.println("Address:" + root.data.streetAddress);
            System.out.println("Zip Code:" + root.data.zipCode);
            System.out.println("Email:" + root.data.email);
            System.out.println("Number:" + root.data.phoneNumber);
            System.out.println();
            inOrderTraversal(root.right);
        }
    }

    // prints tree in post-order
    private void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println("First Name:" + root.data.firstName);
            System.out.println("Last Name:" + root.data.lastName);
            System.out.println("Address:" + root.data.streetAddress);
            System.out.println("Zip Code:" + root.data.zipCode);
            System.out.println("Email:" + root.data.email);
            System.out.println("Number:" + root.data.phoneNumber);
            System.out.println();
        }
    }

    // search for a member by email
    public TreeNode searchMember(String email) {
        return search(root, email);
    }

    // searches for member recursively
    private TreeNode search(TreeNode root, String email) {
        if (root == null || root.data.email.equals(email)) {
            return root;
        }

        int compareResult = email.compareTo(root.data.email);

        if (compareResult < 0) {
            return search(root.left, email);
        } else {
            return search(root.right, email);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Member");
            System.out.println("2. Delete Member");
            System.out.println("3. Modify Member");
            System.out.println("4. Lookup Tree");
            System.out.println("5. Exit");

            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    // add Member
                    System.out.println("Enter first name: ");
                    String firstName = scanner.nextLine();

                    System.out.println("Enter last name: ");
                    String lastName = scanner.nextLine();

                    System.out.println("Enter street address: ");
                    String streetAddress = scanner.nextLine();

                    System.out.println("Enter zip code: ");
                    String zipCode = scanner.nextLine();

                    System.out.println("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.println("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();

                    Member newMember = new Member(firstName, lastName, streetAddress, zipCode, email, phoneNumber);
                    bst.addMember(newMember);
                    break;

                case 2:
                    // delete Member
                    System.out.println("Enter email to delete: ");
                    String deleteEmail = scanner.nextLine();
                    bst.deleteMember(deleteEmail);
                    System.out.println("Member deleted successfully.");
                    break;

                case 3:
                    // modify Member
                    System.out.println("Enter email to modify: ");
                    String modifyEmail = scanner.nextLine();
                    bst.modifyMember(modifyEmail);
                    break;

                case 4:
                    // lookup tree
                    System.out.println("Choose order for tree traversal (pre-order, in-order, post-order): ");
                    String order = scanner.nextLine();
                    bst.displayTree(order);
                    break;

                case 5:
                    // exit
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}