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
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1]; // 1번째, 3번째이므로
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            arr[0] = 0;
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken()); // 누적합 배열 구하기
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()); // a부터 b까지면 b까지의 누적합에서 a-1까지의 누적합을 빼주면 됨
            sb.append(arr[b] - arr[a-1]).append('\n');
        }
        System.out.println(sb);

    }
}
