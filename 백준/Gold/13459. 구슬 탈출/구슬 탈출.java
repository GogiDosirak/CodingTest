import java.io.*;
import java.util.*;

public class Main {
    static char[][] grid;
    static boolean visited[][][][];
    static int N, M;

    static class State {
        int rx, ry, bx, by;
        State(int rx, int ry, int bx, int by) { this.rx = rx; this.ry = ry; this.bx = bx; this.by = by; }
    }

    static class Move {
        int x, y, dist;
        boolean inHole;
        Move(int x, int y, int dist, boolean inHole) { this.x = x; this.y = y; this.dist = dist; this.inHole = inHole; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'R') { rx = i; ry = j; }
                else if (grid[i][j] == 'B') { bx = i; by = j; }
            }
        }

        // 보드는 고정 상태로 두고, R/B는 상태에서만 관리
        grid[rx][ry] = '.';
        grid[bx][by] = '.';

        System.out.println(bfs(rx, ry, bx, by));
    }

    // 구슬 하나를 (dx,dy) 방향으로 끝까지 굴림: 최종 좌표, 이동 칸 수, 구멍 여부 반환
    static Move move(int x, int y, int dx, int dy) {
        int d = 0;
        while (true) {
            char next = grid[x + dx][y + dy];
            if (next == '#') break;
            x += dx; y += dy; d++;
            if (grid[x][y] == 'O') return new Move(x, y, d, true);
        }
        return new Move(x, y, d, false);
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> q = new LinkedList<>();
        visited[rx][ry][bx][by] = true;
        q.add(new State(rx, ry, bx, by));

        int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
        int[] dy = { 0, 0,-1, 1};

        int depth = 0; // 지금까지 기울인 횟수
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                State cur = q.poll();

                for (int dir = 0; dir < 4; dir++) {
                    Move r = move(cur.rx, cur.ry, dx[dir], dy[dir]);
                    Move b = move(cur.bx, cur.by, dx[dir], dy[dir]);

                    // 파랑이 구멍 → 실패 경로(버림)
                    if (b.inHole) continue;
                    // 빨강만 구멍 → 성공
                    if (r.inHole) return 1;

                    // 겹치면 이동거리(dist) 큰 쪽(뒤따라온 구슬)을 한 칸 되돌리기
                    if (r.x == b.x && r.y == b.y) {
                        if (r.dist > b.dist) { r.x -= dx[dir]; r.y -= dy[dir]; }
                        else                 { b.x -= dx[dir]; b.y -= dy[dir]; }
                    }

                    if (!visited[r.x][r.y][b.x][b.y]) {
                        visited[r.x][r.y][b.x][b.y] = true;
                        q.add(new State(r.x, r.y, b.x, b.y));
                    }
                }
            }
            depth++;
            if (depth >= 10) return 0; // 10번 이내 못 빼냈다면 실패
        }
        return 0;
    }
}
