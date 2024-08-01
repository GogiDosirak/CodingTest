import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 누적합 배열 구하기
        }
        int[] sum = new int[N-K+1];
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < K; j++) {
                sum[i] += arr[i+j];
            }
        }

        System.out.println(Arrays.stream(sum).max().getAsInt());


    }
}
