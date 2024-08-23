import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n,a,b,m,cnt;
    static int[][] arr;
    static int[] ch;
    public void BFS(int a) { // 7부터 시작
        cnt = 0;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(a);
        ch[a] = 1;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int q = Q.poll();
                if(q == b) {
                    System.out.println(cnt);
                    return;
                }
                for (int j = 0; j < n+1; j++) {
                    if(arr[q][j] == 1 && ch[j] == 0) {
                        ch[j] = 1;
                        Q.offer(j);
                    }
                }
            }
            cnt++;
        }
        System.out.println(-1);
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        ch = new int[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }
        T.BFS(a);

    }
}

