import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N,M;
    static int[] pm;
    static ArrayList<Integer> arr;
    static HashMap<Integer, Integer> map;
    public void DFS(int L) {
        if(L == M) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < arr.size(); i++) {
                if(map.get(arr.get(i)) > 0) {
                    pm[L] = arr.get(i);
                    map.put(arr.get(i), map.getOrDefault(arr.get(i),0) -1);
                    DFS(L+1);
                    map.put(arr.get(i), map.getOrDefault(arr.get(i),0) +1);
                }
            }

        }

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        map = new HashMap<>();
        HashSet set = new HashSet();
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            set.add(a);
            map.put(a,map.getOrDefault(a,0)+1);
        }
        arr = new ArrayList<>(set);
        Collections.sort(arr);
        pm = new int[M];
        T.DFS(0);


        

    }
}

