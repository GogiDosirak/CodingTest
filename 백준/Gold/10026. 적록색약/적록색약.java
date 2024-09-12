import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static char c1,c2;
    static char[][] arr1, arr2;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public void DFS1(int x, int y) { // 색약 x
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N && arr1[nx][ny] == c1) {
                arr1[nx][ny] = 'C';
                DFS1(nx,ny);
            }
        }
    }
    public void DFS2(int x, int y) { // 색약 O
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N && arr2[nx][ny] == c2) {
                arr2[nx][ny] = 'C';
                DFS2(nx,ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr1 = new char[N][N];
        arr2 = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr1[i][j] = s.charAt(j);
                if(s.charAt(j) == 'G') {
                    arr2[i][j] = 'R'; // R로 통일
                } else {
                    arr2[i][j] = s.charAt(j);
                }
            }
        }

        int answer1 = 0;
        int answer2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr1[i][j] != 'C') {
                    c1 = arr1[i][j];
                    arr1[i][j] = 'C';
                    answer1++;
                    T.DFS1(i,j);
                }

            }

        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr2[i][j] != 'C') {
                    c2 = arr2[i][j];
                    arr2[i][j] = 'C';
                    answer2++;
                    T.DFS2(i,j);
                }
            }

        }
        System.out.println(answer1 + " " + answer2);

    }
}



