package string;

/**
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 *
 * 示例 2：
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class Problem647 {

    public int countSubstrings(String s) {
        int ans = 0;
        int length = s.length();
        // 枚举每一个可能的回文中心，然后用两个指针分别向左右两边拓展，
        // 当两个指针指向的元素相同的时候就拓展，否则停止拓展。
        for (int i = 0; i < length; i++) {
            for(int j=0;j<=1;j++) //j=0,中心是一个点，j=1,中心是两个点
            {
                int left = i;
                int right = i + j;
                while (left >= 0 && right < length && s.charAt(left--) == s.charAt(right++)) {
                    ans++;
                }
            }

        }
        return ans;
    }
}
