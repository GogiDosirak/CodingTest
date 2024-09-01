import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N,M;
    static int[][] arr,dp;
    public int dynamic(int a, int b, int c, int d) {
        int sum = 0;
        // dp[2][4] - dp[2][1] + dp[3][4] - dp[3][1]; 2,2 3,4면..  2,3돌아야하고
        for (int i = a; i <= c; i++) {
            sum = sum + (dp[i][d] - dp[i][b-1]);
        }
        return sum;
        
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N+1][N+1]; // 행별로 누적합
        arr = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < N+1; i++) {
            dp[i][1] = arr[i][1]; // 첫번째 열 초기화
        }
        for (int i = 0; i < N+1; i++) {
            for (int j = 2; j < N+1; j++) {
                dp[i][j] = dp[i][j-1]  + arr[i][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            sb.append(T.dynamic(a,b,c,d)).append('\n');

        }
        System.out.println(sb);






    }
}

