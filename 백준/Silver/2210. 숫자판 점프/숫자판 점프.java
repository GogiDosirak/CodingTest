import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static String s;
    static HashSet<String> set;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public void DFS(int x, int y, String s, int depth) {
        if(depth == 5) {
            set.add(s);
            return;
        }
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                    DFS(nx,ny,s+arr[nx][ny], depth+1);
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
        set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String s = "" + arr[i][j];
                T.DFS(i,j,s,0);

            }

        }
        System.out.println(set.size());



    }
}



