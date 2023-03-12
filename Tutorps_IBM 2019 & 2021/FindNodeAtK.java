/*
 * You're given the root node of a Binary Tree, a target value of a node that's
 * contained in the tree, and a positive integer k. Write a function that
 * returns the values of all the nodes that are exactly distance k from the node
 * with target value.
 * 
 * The distance between two nodes is defined as the number of edges that must be
 * traversed to go from one node to the other. For example, the distance between
 * a node and its immediate left or right child is 1. The same holds in reverse:
 * the distance between a node and its parent is 1. In a tree of three nodes
 * where the root node has a left and right child, the left and right children
 * are distance 2 from each other.
 * 
 * Each BinaryTree node has an integer value, a left child node, and a right
 * child node. Children nodes can either be BinaryTree nodes themselves or None
 * / null.
 * 
 * Note that all BinaryTree node values will be unique, and your function can
 * return the output values in any order.
 */

import java.util.*;

public class FindNodeAtK {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> distanceK(TreeNode root, int target, int k) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();

        // build parent map
        buildParentMap(root, parent, null);

        // perform BFS to find nodes with distance k from target
        Queue<TreeNode> q = new LinkedList<>();
        q.add(getNode(root, target));
        visited.add(getNode(root, target));

        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (dist == k) {
                    res.add(curr.val);
                }
                if (curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                    visited.add(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                    visited.add(curr.right);
                }
                if (parent.get(curr) != null && !visited.contains(parent.get(curr))) {
                    q.add(parent.get(curr));
                    visited.add(parent.get(curr));
                }
            }
            dist++;
            if (dist > k)
                break;
        }

        return res;
    }

    private static void buildParentMap(TreeNode node, Map<TreeNode, TreeNode> parent, TreeNode prev) {
        if (node == null) {
            return;
        }
        parent.put(node, prev);
        buildParentMap(node.left, parent, node);
        buildParentMap(node.right, parent, node);
    }

    private static TreeNode getNode(TreeNode node, int target) {
        if (node == null) {
            return null;
        }
        if (node.val == target) {
            return node;
        }
        TreeNode left = getNode(node.left, target);
        TreeNode right = getNode(node.right, target);
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        int target = 5;
        int k = 2;
        List<Integer> res = distanceK(root, target, k);
        System.out.println(res); // output: [4, 1]
    }
}
