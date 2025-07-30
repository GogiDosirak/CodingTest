import java.util.*;

class Solution {
    static int[] unf;
    public int solution(int n, int[][] costs) {
        unf = new int[n];
        
        for(int i = 0; i < n; i++) {
            unf[i] = i;
        }
        
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        int answer = 0;
        int edge = 0;
        
        for(int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];
            
            if(find(from) != find(to)) {
              union(from, to);
              answer += cost;
              edge++;
            }
            
            if(edge == n - 1) {
                break;
            }   
        }
        return answer;
    }
    
    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) {
            unf[fa] = fb;
        }
    }
    
    public static int find(int v) {
        if(v == unf[v]) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }
}