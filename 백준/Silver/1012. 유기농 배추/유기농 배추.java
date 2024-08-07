import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T,N,M,K, answer;
    static int[][] arr;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 1) {
                arr[nx][ny] = 0;
                DFS(nx,ny);

            }

        }


    }
    public static void main(String[] args) throws IOException {
        Main P = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로길이
            N = Integer.parseInt(st.nextToken()); // 세로길이
            K = Integer.parseInt(st.nextToken()); // 배추의 개수
            arr = new int[N][M];
            answer = 0;
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[b][a] = 1;
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(arr[j][k] == 1) {
                        arr[j][k] = 0;
                        P.DFS(j,k);
                        answer++;
                    }

                }

            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb);




        }
    }

