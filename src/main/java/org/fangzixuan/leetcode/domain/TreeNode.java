package org.fangzixuan.leetcode.domain;

/**
 * binary tree node with value
 *
 * @author BebopFish
 * @since 2021/3/9
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
