//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 215 👎 0


package org.fangzixuan.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        int[] test = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        solution.maxSlidingWindow(test, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0 || k == 0) {
                return new int[0];
            }
            Deque<Integer> sortedWindow = new ArrayDeque<>();
            int left = 0, right = 0;
            int[] res = new int[nums.length - k + 1];
            sortedWindow.addLast(nums[right]);
            while (true) {
                if (right - left >= k && sortedWindow.getFirst() == nums[left++]) {
                    sortedWindow.pollFirst();
                }
                if (right - left == k - 1) {
                    res[left] = sortedWindow.getFirst();
                }
                right++;
                if (right == nums.length) {
                    break;
                }
                while (!sortedWindow.isEmpty() && (sortedWindow.getLast() < nums[right])) {
                    sortedWindow.pollLast();
                }
                sortedWindow.addLast(nums[right]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}