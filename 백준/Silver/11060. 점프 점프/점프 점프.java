import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp, arr;

    public void dynamic(int x) {
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= arr[i]; j++) {
                if(dp[i] == Integer.MAX_VALUE) {
                    continue;
                }
                if(i+j < N) {
                    dp[i + j] = Math.min(dp[i+ j], dp[i] + 1);
                } else {
                    dp[N - 1] = Math.min(dp[N-1], dp[i] + 1);
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N]; // 해당 칸까지 올 수 있는 최단점프 (MIN값)
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        T.dynamic(0);
        if(dp[N-1] == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(dp[N - 1]);
        }





    }
}