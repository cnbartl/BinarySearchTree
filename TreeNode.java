// Cooper Bartl
// CS145
// 3/13/2024

// This class manages each node in the Binary Search Tree.
// Each node contains member data and a reference to its left and right children.

class TreeNode {
    Member data; // contains member data
    TreeNode left; // contains left reference
    TreeNode right; // contains right reference

    public TreeNode(Member data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
