import java.io.*;
import java.util.*;

public class Main {
    static char[][] grid;
    static boolean visited[][][][];
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M][N][M];
        grid = new char[N][M];
        int redX = 0, redY = 0, blueX = 0, blueY = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'R') {
                    redX = i; redY = j;
                    grid[i][j] = '.'; // R 자리는 빈 칸으로
                } else if (grid[i][j] == 'B') {
                    blueX = i; blueY = j;
                    grid[i][j] = '.'; // B 자리는 빈 칸으로
                }
            }
        }

        Main T = new Main();
        System.out.println(T.BFS(redX, redY, blueX, blueY));
    }

    public int BFS(int redX, int redY, int blueX, int blueY) {
        Queue<State> queue = new LinkedList<>();
        visited[redX][redY][blueX][blueY] = true;
        queue.add(new State(redX, redY, blueX, blueY));
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State now = queue.poll();

                // 4방향 기울이기
                for (int d = 0; d < 4; d++) {
                    State state = move(now, d);

                    if (grid[state.blueX][state.blueY] == 'O') continue; // 파란 구슬 들어가면 실패
                    if (grid[state.redX][state.redY] == 'O') return 1; // 빨간 구슬 성공

                    if (!visited[state.redX][state.redY][state.blueX][state.blueY]) {
                        visited[state.redX][state.redY][state.blueX][state.blueY] = true;
                        queue.add(state);
                    }
                }
            }
            count++;
            if (count >= 10) return 0; // 10번 초과는 실패
        }
        return 0;
    }

    // d = 0: up, 1: down, 2: left, 3: right
    public State move(State s, int d) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int redX = s.redX, redY = s.redY;
        int blueX = s.blueX, blueY = s.blueY;

        // 먼저 빨간 구슬 이동
        int rMove = 0;
        while (grid[redX + dx[d]][redY + dy[d]] != '#' && grid[redX][redY] != 'O') {
            redX += dx[d];
            redY += dy[d];
            rMove++;
            if (grid[redX][redY] == 'O') break;
        }

        // 파란 구슬 이동
        int bMove = 0;
        while (grid[blueX + dx[d]][blueY + dy[d]] != '#' && grid[blueX][blueY] != 'O') {
            blueX += dx[d];
            blueY += dy[d];
            bMove++;
            if (grid[blueX][blueY] == 'O') break;
        }

        // 같은 위치에 멈추면 이동거리 비교해서 하나 뒤로 물리기
        if (redX == blueX && redY == blueY && grid[redX][redY] != 'O') {
            if (rMove > bMove) { // 빨간 구슬이 더 멀리 왔다면 한 칸 뒤로
                redX -= dx[d];
                redY -= dy[d];
            } else {
                blueX -= dx[d];
                blueY -= dy[d];
            }
        }

        return new State(redX, redY, blueX, blueY);
    }
}

class State {
    int redX, redY, blueX, blueY;
    public State(int redX, int redY, int blueX, int blueY) {
        this.redX = redX;
        this.redY = redY;
        this.blueX = blueX;
        this.blueY = blueY;
    }
}
