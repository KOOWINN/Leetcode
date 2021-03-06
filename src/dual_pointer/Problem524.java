package dual_pointer;

import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 示例 1:
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * 输出:
 * "apple"
 *
 * 示例 2:
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 *
 * 输出:
 * "a"
 * 说明:
 *
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 */
public class Problem524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String maxStr = "";
        for (String item : dictionary) {
            if (isSubStr(item, s)) {
                if (item.length() > maxStr.length() || (item.length() == maxStr.length() && item.compareTo(maxStr) < 0)) {
                    maxStr = item;
                }
            }
        }
        return maxStr;
    }

    private boolean isSubStr(String item, String s) {
        int i = 0;  //item字符串的索引
        int j = 0;  //s字符串的索引
        for (; i < item.length() && j < s.length(); j++) {
            if (item.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        return i == item.length();
    }
}
