/*
 * Write a function that takes in a Binary Tree and returns its max path sum.
 * A path is a collection of connected nodes in a tree, where no node is
 * connected to more than two other nodes; a path sum is the sum of the values
 * of the nodes in a particular path.
 * Each BinaryTree node has an integer value, a left child node, and a right
 * child node. Children nodes can either be BinaryTree nodes themselves or None
 * / null.
 */

public class MaxPath {

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
        }
    }

    static int maxPathSum(BinaryTree tree) {
        int[] maxSum = { Integer.MIN_VALUE };
        maxPathSumHelper(tree, maxSum);
        return maxSum[0];
    }

    static int maxPathSumHelper(BinaryTree node, int[] maxSum) {
        if (node == null) {
            return 0;
        }

        int leftMaxSum = maxPathSumHelper(node.left, maxSum);
        int rightMaxSum = maxPathSumHelper(node.right, maxSum);

        int maxPathSumEndingAtNode = Math.max(Math.max(leftMaxSum, rightMaxSum) + node.value, node.value);
        int maxPathSumThroughNode = Math.max(leftMaxSum + node.value + rightMaxSum, maxPathSumEndingAtNode);
        maxSum[0] = Math.max(maxSum[0], maxPathSumThroughNode);

        return maxPathSumEndingAtNode;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);

        System.out.println(maxPathSum(tree)); // Output: 18
    }
}
