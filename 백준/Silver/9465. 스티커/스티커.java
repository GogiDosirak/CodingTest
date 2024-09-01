import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N,T;
    static int[][] arr,dp;
    public int dynamic() {
            for (int j = 2; j < N; j++) {
                    dp[0][j] = Math.max(dp[1][j-1],Math.max(dp[0][j-2], dp[1][j-2])) + arr[0][j];
                    dp[1][j] = Math.max(Math.max(dp[1][j-2], dp[0][j-2]),dp[0][j-1]) + arr[1][j];

            }
        int answer = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, dp[i][j]);
            }

        }
        return  answer;


    }
    public static void main(String[] args) throws IOException {
        Main P = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[2][N];
            dp = new int[2][N];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            if(N > 1) {
                dp[0][1] = arr[1][0] + arr[0][1];
                dp[1][1] = arr[0][0] + arr[1][1];
            }
            System.out.println(P.dynamic());
        }







    }
}

