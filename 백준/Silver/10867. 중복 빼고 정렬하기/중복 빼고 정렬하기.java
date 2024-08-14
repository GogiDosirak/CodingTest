import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] count = new int[2001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            count[arr[i]+1000]++;
        }
        int max = Arrays.stream(arr).max().getAsInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                sb.append(i-1000).append(" ");
            }

        }
        System.out.println(sb);

    }
}

