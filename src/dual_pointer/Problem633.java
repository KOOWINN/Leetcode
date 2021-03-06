package dual_pointer;

/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a*a + b*b = c 。
 *
 * 示例 1：
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 *
 * 示例 2：
 * 输入：c = 3
 * 输出：false
 *
 * 示例 3：
 * 输入：c = 4
 * 输出：true
 *
 * 示例 4：
 * 输入：c = 2
 * 输出：true
 *
 * 示例 5：
 * 输入：c = 1
 * 输出：true
 *
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 */
public class Problem633 {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int)Math.sqrt(c);
        while (left <= right) {
            long product = left * left + right * right;
            if (product == c) {
                return true;
            } else if (product < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
