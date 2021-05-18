package array;

/**
 * 485. 最大连续 1 的个数
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 *
 * 示例：
 *
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *
 *
 * 提示：
 *
 * 输入的数组只包含 0 和 1 。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
public class Problem485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;   //记录最大的连续 1 的个数和当前的连续 1 的个数
        int curr = 0;  //记录当前的连续 1 的个数
        for (int num : nums) {
            if (num == 1) {
                curr++;
            } else {
                curr = 0;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}
