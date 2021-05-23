package array;

/**
 * 667. 优美的排列 II
 * 给你两个整数 n 和 k ，请你构造一个答案列表 answer ，该列表应当包含从 1 到 n 的 n 个不同正整数，并同时满足下述条件：
 *
 * 假设该列表是 answer = [a1, a2, a3, ... , an] ，那么列表 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数。
 * 返回列表 answer 。如果存在多种答案，只需返回其中 任意一种 。
 *
 *
 *
 * 示例 1：
 * 输入：n = 3, k = 1
 * 输出：[1, 2, 3]
 * 解释：[1, 2, 3] 包含 3 个范围在 1-3 的不同整数，并且 [1, 1] 中有且仅有 1 个不同整数：1
 *
 * 示例 2：
 * 输入：n = 3, k = 2
 * 输出：[1, 3, 2]
 * 解释：[1, 3, 2] 包含 3 个范围在 1-3 的不同整数，并且 [2, 1] 中有且仅有 2 个不同整数：1 和 2
 */
public class Problem667 {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];

        // 第1步：构造等差数列，把1到n-k-1赋值给结果数组的前面
        for (int i = 0; i < n - k - 1; i++) {
            ans[i] = i+1;
        }

        // 第2步：构造交错数列，下标从n-k-1开始，数值从n-k开始，控制交错的变量
        int j = 0;
        int left = n - k;
        int right = n;
        for (int i = n-k-1; i <n; i++) {
            if (j % 2 == 0) {
                ans[i] = left;
                left++;
            } else {
                ans[i] = right;
                right--;
            }
            j++;
        }
        return ans;
    }
}