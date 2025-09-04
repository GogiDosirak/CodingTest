import java.util.*;

class Solution {
    boolean[] visited;
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        List<Integer> list = new ArrayList<>();
        backtracking(k, dungeons, list);
        return answer;
    }
    
    public void backtracking(int k, int[][] dungeons, List<Integer> list) {
        answer = Math.max(answer, list.size());
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i] == false && k >= dungeons[i][0]) {
                k -= dungeons[i][1];
                visited[i] = true;
                list.add(i);
                backtracking(k, dungeons, list);
                list.remove(list.size() - 1);
                visited[i] = false;
                k += dungeons[i][1];
            }
        }
    }
}