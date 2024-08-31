import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static int[] arr;
    static Integer[] dp;
    public int dynamic(int n) {
        if(dp[n] == null) {
            return dp[n] = Math.max(Math.max(dynamic(n-2), dynamic(n-3) + arr[n-1]) + arr[n], dynamic(n-1));
        }
        return dp[n];

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new Integer[n+1]; // i번까지 왔을 때의 최대 포도주
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = arr[1];
        if(n > 1) {
            dp[2] = arr[1] + arr[2];
        }
        System.out.println(T.dynamic(n));


    }
}

