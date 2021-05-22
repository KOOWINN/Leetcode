package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 *
 * 示例 2：
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 *
 *
 * 提示：
 *
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 */
public class Problem207 {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        // 构造有向图
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0)
                dfs(i);
        }
        return valid;
    }

    private void dfs(int u) {
        visited[u] = 1; // 标记正在访问u节点
        // 访问u节点的所有相邻节点
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {  // 如果节点v没有访问过
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) { // 如果节点v正在访问中
                valid = false;
                return;
            }
        }
        visited[u] = 2;  //标记节点u访问结束
    }

    int[] inDegrees; //用来记录每个节点的入度，即有多少箭头指向该节点
    public boolean canFinishInBfs(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        inDegrees = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);  // 构造一条先修课程指向后修课程的边
            inDegrees[info[0]]++;             // 后修课程的入度加1
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) { // 如果当前节点的入度为0，说明不需要先修课程或先修课程已完成，所以将当前课程加入待学习队列中
                queue.offer(i);
            }
        }

        int visited = 0;   // 统计已经学习的课程数量
        while (!queue.isEmpty()) {
            int u = queue.poll();  //弹出队列的首部元素，即从待学习队列中选择第一个课程进行学习
            ++visited;
            for (int v : edges.get(u)) {  //所有后继节点的入度减1，如果某个后继节点的入度变为0，则说明该节点可以访问了，放入队列中
                --inDegrees[v];
                if (inDegrees[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;  // 如果visited等于当前节点数，则说明存在拓扑排序，即可以修完所有的课程。
    }
}
