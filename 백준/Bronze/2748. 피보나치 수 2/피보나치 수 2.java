import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static long[] dp;
    public long dynamic(int N) {
            for (int i = 2; i <= N; i++) {
                dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N == 0) {
            System.out.println(0);
            return;
        }
        if(N == 1) {
            System.out.println(1);
            return;
        }
        dp = new long[N+1];
        dp[0] = 0;
        dp[1] = 1;
        System.out.println(T.dynamic(N));

    }
}

