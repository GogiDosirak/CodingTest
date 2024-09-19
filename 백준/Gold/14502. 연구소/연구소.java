import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N,M;
    static int answer = 0;
    static int[][] arr, copy;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};

    public void BFS() {
        Queue<Node> Q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copy[i][j] == 2) {
                    Q.offer(new Node(i,j));
                }
            }
        }
        while(!Q.isEmpty()) {
            Node n = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && copy[nx][ny] == 0) {
                    copy[nx][ny] = 2;
                    Q.offer(new Node(nx,ny));
                }
            }
        }

    }
    public void DFS(int wall) { // 완전탐색으로 벽세우기
        if(wall == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copy[i][j] = arr[i][j];
                }
            }
            BFS();
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(copy[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    DFS(wall+1);
                    arr[i][j] = 0;
                }
            }

        }


    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        copy = new int[N][M];
        T.DFS(0);
        System.out.println(answer);






        


    }
}



