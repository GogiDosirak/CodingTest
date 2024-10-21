import java.io.*;
import java.util.*;

class Edge {
    int x, y;

    public Edge(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static int[][] arr, dist;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dist = new int[N][M];  // 최소 거리 저장 배열
        Queue<Edge> Q = new LinkedList<>();

        // 입력을 받으면서 상어 위치를 큐에 추가
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    Q.add(new Edge(i, j));  // 상어 위치를 BFS 시작점으로
                    dist[i][j] = 0;  // 상어가 있는 칸의 거리 = 0
                } else {
                    dist[i][j] = -1;  // 아직 방문하지 않은 칸
                }
            }
        }

        // BFS 수행 (여러 상어로부터 동시에 탐색)
        while (!Q.isEmpty()) {
            Edge e = Q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = e.x + dx[i];
                int ny = e.y + dy[i];

                // 범위를 벗어나지 않고, 아직 방문하지 않은 칸이면
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[e.x][e.y] + 1;  // 거리 갱신
                    Q.add(new Edge(nx, ny));  // 큐에 추가
                }
            }
        }

        // 안전 거리의 최댓값 찾기
        int maxDistance = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxDistance = Math.max(maxDistance, dist[i][j]);
            }
        }

        // 결과 출력
        System.out.println(maxDistance);
    }
}