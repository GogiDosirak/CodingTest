import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int[] p, dp;
    public void dynamic() {
        for (int i = 2; i < N+1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + p[j]);
            }
        }


    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        p = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N+1]; // i장을 살 때의 최대비용
        dp[1] = p[1];
        T.dynamic();
        System.out.println(dp[N]);
    }
}


