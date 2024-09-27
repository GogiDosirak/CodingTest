import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] dp1, dp2;
    static int ax, ay;

    // 출발점에서 경유점까지의 경로 계산
    public void dynamic1(int x, int y) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (i == 1 && j == 1) continue;
                dp1[i][j] = (i > 1 ? dp1[i - 1][j] : 0) + (j > 1 ? dp1[i][j - 1] : 0);
            }
        }
    }

    // 경유점에서 도착점까지의 경로 계산
    public void dynamic2(int x, int y) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (i == 1 && j == 1) continue;
                dp2[i][j] = (i > 1 ? dp2[i - 1][j] : 0) + (j > 1 ? dp2[i][j - 1] : 0);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 경유점 K가 있을 때 좌표 계산
        if (K != 0) {
            ax = (K - 1) / M + 1;
            ay = (K - 1) % M + 1;
        } else {
            ax = 0;
            ay = 0;
        }

        // DP 배열 초기화
        dp1 = new int[N + 1][M + 1];
        dp2 = new int[N + 1][M + 1];
        dp1[1][1] = 1;
        dp2[1][1] = 1;

        if (K != 0) {
            // 출발점에서 경유점까지의 경로 계산
            T.dynamic1(ax, ay);
            // 경유점에서 도착점까지의 경로 계산
            T.dynamic2(N - ax + 1, M - ay + 1);
            // 결과는 출발점->경유점 경로와 경유점->도착점 경로의 곱
            int answer = dp1[ax][ay] * dp2[N - ax + 1][M - ay + 1];
            System.out.println(answer);
        } else {
            // 경유점이 없을 경우, 출발점에서 도착점까지 직접 경로 계산
            T.dynamic1(N, M);
            System.out.println(dp1[N][M]);
        }
    }
}