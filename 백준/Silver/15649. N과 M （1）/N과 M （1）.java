import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N, M = 0;
    static int[] arr;
    static int[] ch;
    static StringBuilder sb = new StringBuilder();
    public void DFS(int L) {
        if(L == M) {
            for(int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append('\n');
        } else {
            for (int i = 1; i <= N; i++) {
                if(ch[i] == 0) { // 사용한적 없을 때만 재귀돌기
                    ch[i] = 1;
                    arr[L] = i; // 사용했다면 더이상 재귀 x -> L == M이 안되므로 출력 x
                    DFS(L + 1);
                    ch[i] = 0; // 재귀가 끝나면 돌아왔으므로 다시 0
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
        arr = new int[M];
        ch = new int[N+1];
        T.DFS(0);
        System.out.println(sb);



    }
}
