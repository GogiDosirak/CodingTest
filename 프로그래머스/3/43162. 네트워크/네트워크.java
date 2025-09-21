import java.io.*;
import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        // 네트워크의 개수 판별 -> grid에서 같은 빙산?의 영역 구하는 것과 같다. 그것의 그래프 버전
        // 1이면 탐색 시작 count ++ -> 방문했다면 0으로 바꿔주고.. 1이면 또 탐색 시작하고 count++
        int answer = 0;
        
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < computers.length; i++) {
            list.add(new ArrayList<>());
            for(int j = 0; j < computers[i].length; j++) {
                // 연결이 있을 때만 1
                if(computers[i][j] == 1 && i != j) {
                    list.get(i).add(j);
                }
            }
        }
        
        visited = new boolean[computers.length];
        
        for(int i = 0; i < computers.length; i++) {
            // 해당 노드를 탐색하지 않았다면
            if(visited[i] == false) {
                visited[i] = true;
                answer++;
                DFS(list, i);
            }
        }
        return answer;
    }
    
    public void DFS(List<List<Integer>> list, int node) {
        for(int n : list.get(node)) {
            if(visited[n] == false) {
                visited[n] = true;
                DFS(list, n);
            }
        }
    }
}