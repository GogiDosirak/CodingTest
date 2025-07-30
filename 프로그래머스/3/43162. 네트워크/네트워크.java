import java.util.*;

class Solution {
    static int[] unf;
    public int solution(int n, int[][] computers) {
        unf = new int[computers.length];
        
        for(int i = 0; i < unf.length; i++) {
            unf[i] = i;
        }
        
        for(int i = 0 ; i < computers.length; i++) {
            for(int j = 0; j < computers[0].length; j++) {
                if(i != j && computers[i][j] == 1) {
                    union(i,j);
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < unf.length; i++) {
            set.add(find(i));
        }
        
        return set.size();
        
      
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