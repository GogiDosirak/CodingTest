import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R,C;
    static char[][] arr;
    static boolean[] ch;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    static int answer;
    public void DFS(int x, int y, int cnt) {
        answer = Math.max(answer,cnt);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < R && ny >= 0 && ny < C && ch[arr[nx][ny] - 'A'] == false) {
                ch[arr[nx][ny] - 'A'] = true;
                DFS(nx,ny, cnt+1);
                ch[arr[nx][ny] - 'A'] = false; 
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = s.charAt(j);
                arr[i][j] = c;
            }
        }
        answer = 0;

        ch = new boolean[26]; // contains는 시간복잡도가 매우 길다. -> boolean 배열로 char - 'A'해주는 식으로 하는게 더 좋음.
        ch[arr[0][0] - 'A'] = true;
        T.DFS(0,0,1);
        System.out.println(answer);

    }
}

