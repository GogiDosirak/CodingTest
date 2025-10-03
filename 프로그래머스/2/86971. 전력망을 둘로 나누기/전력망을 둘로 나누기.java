import java.util.*;

class Solution {
    boolean[] visited;
    int count;
    public int solution(int n, int[][] wires) {
        // n개의 송전탑이 트리 형태로 연결 (이진 트리는 아닌듯?)
        // 전선(edge) 하나를 끊어서 네트워크를 2개로 분할하되, 두 네트워크가 갖게되는 송전탑의 개수를 최대한 비슷하게 맞춰야함
        // 두 전력망이 가진 송전탑 개수의 차이(절대값)를 return 
        
        // 2 <= n < = 100
        // wires 배열 - 두 송전탑의 연결 정보
        
        // 2 <= n <= 100 / 간선은 n-1이니까 모든 간선을 잘라보고, 각각의 개수를 비교해도 괜찮을듯?
        // O(n^2) 충분히 가능
        
        List<List<Integer>> graph = new ArrayList<>();
        int answer = Integer.MAX_VALUE;
        // 양방향
        // 0부터 n+1까지 (1번부터 시작하므로)
        for(int i = 0; i <= wires.length + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < wires.length; i++) {
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }
        
        // 간선 없애고, DFS 돌고, 다시 간선 복구
        // 한쪽 네트워크의 개수를 구하면, 다른쪽은 n - size
        for(int[] w : wires) {
            // 값으로 제거하려면 Integer로 변환
            graph.get(w[0]).remove(Integer.valueOf(w[1]));
            graph.get(w[1]).remove(Integer.valueOf(w[0]));
                
            visited = new boolean[wires.length+2];
            // 시작점은 어디서 시작하든 상관없음. 두 네트워크로만 나누면 되기 때문에
            // 전역 변수 초기화
            count = 0;
            DFS(graph, 1);
            int anotherCount = (wires.length + 1) - count;
            
            answer = Math.min(answer, Math.abs(count - anotherCount));
            
            // 간선 복구
            graph.get(w[0]).add(w[1]);
            graph.get(w[1]).add(w[0]);
        }
        
        return answer;
    } 
    
    // DFS로 탐색, visited 배열로 갔는지 확인 후, 안 간 곳이라면 탐색
    public void DFS(List<List<Integer>> list, int node) {
        visited[node] = true;
        count++;
        for(int n : list.get(node)) {
            if(visited[n] != true) {
                // 현재 탐색 가능한 노드의 개수를 구함
                DFS(list, n);
                // 두 네트워크로 나눠져 있어 한번 방문한 노드는 다시 방문할 일이 없으므로, 굳이 롤백 필요 X
            }
        }
    }     
}