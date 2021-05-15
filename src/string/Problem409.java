package string;

/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class Problem409 {
    public int longestPalindrome(String s) {
        int[] cnts = new int[52];
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                cnts[c - 'a']++;
            } else {
                cnts[26 + c - 'A']++;
            }
        }
        int ans = 0;
        boolean oddMark = false;
        for (int cnt : cnts) {
            ans += cnt;
            // 如果当前字母的个数是奇数，则去除一个
            if (cnt % 2 == 1) {
                ans--;
                oddMark = true;
            }
        }
        if (oddMark) ans++;
        return ans;
    }
}
