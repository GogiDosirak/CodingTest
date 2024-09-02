import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] min, max, arr;
    public int min(int N) {
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if(j == 0) {
                    min[i][j] = Math.min(min[i-1][j], min[i-1][j+1]) + arr[i][j];
                }
                if(j == 1) {
                    min[i][j] = Math.min(Math.min(min[i-1][j-1], min[i-1][j]), min[i-1][j+1]) + arr[i][j];
                }
                if(j == 2) {
                    min[i][j] = Math.min(min[i-1][j-1], min[i-1][j]) + arr[i][j];
                }
            }
        }
        int answer = 9999999;
        for (int i = 0; i < 3; i++) {
            answer = Math.min(answer,min[N-1][i]);
        }
        return answer;


    }

    public int max(int N) {
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if(j == 0) {
                    max[i][j] = Math.max(max[i-1][j], max[i-1][j+1]) + arr[i][j];
                }
                if(j == 1) {
                    max[i][j] = Math.max(Math.max(max[i-1][j-1], max[i-1][j]), max[i-1][j+1]) + arr[i][j];
                }
                if(j == 2) {
                    max[i][j] = Math.max(max[i-1][j-1], max[i-1][j]) + arr[i][j];
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer = Math.max(answer,max[N-1][i]);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = new int[N][3];
        max = new int[N][3];
        arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min[0][0] = max[0][0] = arr[0][0];
        min[0][1] = max[0][1] = arr[0][1];
        min[0][2] = max[0][2] = arr[0][2];
        System.out.print(T.max(N) + " " + T.min(N));

    }
}


