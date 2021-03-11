//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 922 👎 0


package org.fangzixuan.leetcode.editor.cn;

import org.fangzixuan.leetcode.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void mail(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, inMap, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, Map<Integer, Integer> inMap, int pLeft, int pRight, int iLeft, int iRight) {
        if (pLeft >= pRight || iLeft >= iRight) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pLeft]);
        int index = inMap.getOrDefault(preorder[pLeft], -1);
        if (index == -1) {
            return null;
        }
        node.left = buildTree(preorder, inorder, inMap, pLeft + 1, pLeft + index - iLeft + 1, iLeft, index);
        node.right = buildTree(preorder, inorder, inMap, pRight - iRight + index + 1, pRight, index + 1, iRight);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}