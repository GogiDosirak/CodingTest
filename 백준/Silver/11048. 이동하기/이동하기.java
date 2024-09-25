import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    static int N, M, answer, sum;
    static int[][] arr;
    static int[][] dp;
    public void DFS() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(dp[i][j-1],Math.max(dp[i-1][j], dp[i-1][j-1])) + arr[i][j];
            }
        }




    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        dp = new int[N+1][M+1];
        dp[1][1] = arr[1][1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sum += arr[1][1];
        T.DFS(); //1,1에서 3,4로 이동할 때 가져올 수 있는 사탕 개수
        System.out.println(dp[N][M]);
    }
}

// 1000 * 1000 = 100000이므로 DFS로 풀면 시간초과! -> DP로 변형해보자.