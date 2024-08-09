import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,V;
    static ArrayList<ArrayList<Integer>> arr;
    static int[] ch1, ch2;
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    public void DFS(int v) {
        sb1.append(v).append(" ");
        for(int a : arr.get(v)) {
            if(ch1[a] == 0) {
                ch1[a] = 1;
                DFS(a);
            }
        }
    }
    public void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        while(!Q.isEmpty()) {
            int nv = Q.poll();
            sb2.append(nv).append(" ");
            for(int a : arr.get(nv)) {
                if(ch2[a] == 0) {
                    Q.offer(a);
                    ch2[a] = 1;
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
        V = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        ch1 = new int[N+1];
        ch2 = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        for (int i = 0; i < arr.size(); i++) {
            Collections.sort(arr.get(i)); // i별로 정렬
        }
        ch1[V] = 1;
        ch2[V] = 1;
        T.DFS(V);
        T.BFS(V);
        System.out.println(sb1);
        System.out.println(sb2);


    }
}

