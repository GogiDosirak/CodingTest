import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,answer;
    static ArrayList<ArrayList<Integer>> arr;
    static int[] ch;
    public void DFS(int v) {
        ch[v] = 1;
        for(int x : arr.get(v)) {
            if(ch[x] == 0) {
                ch[x] = 1;
                DFS(x);
            }

        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        ch = new int[N+1];

        for (int i = 1; i <= N; i++) {
            if(ch[i] == 0) {
                T.DFS(i);
                answer++;
            }
        }

        System.out.println(answer);
        

    }
}

