import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int[] arr,dp;
    static int answer = 1;
    public void dynamic() {
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if(arr[i] < arr[j] && max < dp[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]);
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N]; // arr[i]번째 수가 최소값일 때의 길이
        dp[0] = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        T.dynamic();
        System.out.println(answer);
    }
}


