import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[w];
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 1; i < w-1; i++) { // 첫인덱스와 마지막 인덱스엔 빗물 x
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]); // 현재인덱스까지의 최고높이 찾기 (왼쪽)
            }
            for (int j = i+1; j < w; j++) {
                right = Math.max(right,arr[j]); // 다음인덱스부터 최고높이 찾기 (오른쪽)
            }

            if(left > arr[i] && right > arr[i]) { // 왼쪽이나 오른쪽 높이보다 낮아야 빗물이 고이고.
                answer += Math.min(left,right) - arr[i]; // 둘중 작은 높이를 기준으로 빗물이 고임
            }

        }
        System.out.println(answer);

    }
}

