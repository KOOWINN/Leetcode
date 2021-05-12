package stackAndQueue;

import java.util.Stack;

/**
 * 739. 每日温度
 * 请根据每日气温列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class Problem739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        // 存储下标的单调栈，从栈底到栈顶的下标对应的温度列表中的温度依次递减。
        // 如果一个下标在单调栈里，则表示尚未找到下一次温度更高的下标。
        Stack<Integer> stack = new Stack<>();
        for (int currentIndex = 0; currentIndex < length; currentIndex++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[currentIndex]) {
                int preIndex = stack.pop();
                ans[preIndex] = currentIndex - preIndex;
            }
            stack.push(currentIndex);
        }
        return ans;
    }
}
