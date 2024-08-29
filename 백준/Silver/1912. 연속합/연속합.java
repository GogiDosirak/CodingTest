import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, max;
    static int[] arr;
    static int[] dp;
    public void dynamic(int N) {
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
        }
    }
 public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        max = -999999;
        StringTokenizer st = new StringTokenizer(br.readLine());
     for (int i = 0; i < N; i++) {
         arr[i] = Integer.parseInt(st.nextToken());
     }
     dp[0] = arr[0];
     T.dynamic(N);
     for (int i = 0; i < N; i++) {
         max = Math.max(max, dp[i]);
     }
     System.out.println(max);



    }
}

