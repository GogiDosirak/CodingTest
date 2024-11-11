import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int r, c;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean found = false;  // 사과 2개를 먹을 수 있으면 true로 설정

    public void DFS(int r, int c, int move, int apples) {
        // 이동 횟수가 3을 초과하면 중단
        if (move > 3) return;

        // 사과를 두 개 이상 먹은 경우
        if (apples >= 2) {
            found = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            // 유효한 위치인지 및 장애물이 아닌지 확인
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && arr[nx][ny] != -1) {
                int temp = arr[r][c];
                arr[r][c] = -1;  // 현재 위치를 장애물로 설정

                DFS(nx, ny, move + 1, apples + (arr[nx][ny] == 1 ? 1 : 0));

                arr[r][c] = temp;  // 원래 상태로 복구

                // 사과를 두 개 이상 먹으면 더 탐색할 필요 없음
                if (found) return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        T.DFS(r, c, 0, 0);

        System.out.println(found ? 1 : 0);
    }
}