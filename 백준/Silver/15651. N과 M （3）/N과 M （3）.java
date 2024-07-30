import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N, M = 0;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public void DFS(int L) {
        if(L == M) {
            for(int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append('\n');
        } else {
            for (int i = 1; i <= N; i++) {
                arr[L] = i;
                DFS(L+1);
            }

        }


    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        T.DFS(0);
        System.out.println(sb);



    }
}
