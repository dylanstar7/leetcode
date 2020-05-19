package leetcode.answer.impl.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author lijiakun
 * @date 2020/05/17 20:41
 */
public class findOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] course : prerequisites){
            int tar = course[1];
            int src = course[0];
            List<Integer> list = map.getOrDefault(src, new ArrayList<>());
            list.add(tar);
            map.put(src, list);
        }


        //访问标志设置
        int[] visited = new int[numCourses];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i<numCourses;i++){
            if(!dfs(i,map,visited,ans)){
                return new int[0];
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     *  node: 当前节点
     *  map: 图
     *  visited: 0表示未访问, 1表示访问中, 2表示访问完成
     *  ans: 储存拓扑排序结果
     * return: 是否无环
     */
    private boolean dfs(int node, Map<Integer, List<Integer>> map, int[] visited, List<Integer> ans) {
        if(visited[node] == 2){
            return true;
        }

        if(visited[node] == 1){
            //发现环
            return false;
        }

        //设置当前为为访问中
        visited[node] = 1;

        if(!map.containsKey(node)){
            ans.add(node);
            visited[node] = 2;
            return true;
        }

        List<Integer> targets = map.get(node);
        for(int tar:targets){
            if(!dfs(tar,map,visited,ans)){
                return false;
            }
        }

        visited[node] = 2;
        ans.add(node);
        return true;
    }
}
