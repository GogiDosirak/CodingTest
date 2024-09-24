import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] H = new int[N]; // 체력-
        int[] L = new int[N]; // 기쁨+

        int[] dx = new int[100]; // 남은 체력에 따라 얻을 수 있는 최대 기쁨의 값

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 99; j >= H[i]; j--) {
                dx[j] = Math.max(dx[j], dx[j-H[i]] + L[i]);
            }
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            answer = Math.max(dx[i], answer);
        }

        System.out.println(answer);




    }
}