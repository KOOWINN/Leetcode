package stackAndQueue;

import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class Problem20 {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if (stack.isEmpty() || !matchCharacter(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean matchCharacter(char a, char b) {
        if ((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}')) {
            return true;
        } else {
            return false;
        }
    }
}
