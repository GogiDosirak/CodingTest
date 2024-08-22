import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R,C;
    static char[][] arr;
    static ArrayList<Character> ch;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    static int answer, cnt;
    public void DFS(int x, int y, int cnt) {
        answer = Math.max(answer,cnt);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < R && ny >= 0 && ny < C && !ch.contains(arr[nx][ny])) {
                ch.add(arr[nx][ny]);
                DFS(nx,ny, cnt+1);
                ch.remove(ch.size()-1); // 제일 뒤의 얘를 지워주면 됨
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
        ch = new ArrayList<>();
        ch.add(arr[0][0]);
        T.DFS(0,0,1);
        System.out.println(answer);



    }
}

