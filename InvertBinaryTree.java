/*
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        String[] input = new String[]{"ate", "eat", "tea", "tan", "nat", "bat"};
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        return inorder(root);
    }

    private TreeNode inorder(TreeNode root) {
        if (root == null)
            return null;
        TreeNode leftNode = inorder(root.left);
        TreeNode rightNode = inorder(root.right);
        root.right = leftNode;
        root.left = rightNode;
        return root;
    }
}
