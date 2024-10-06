import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N,M,time, count;
    static int[][] arr, copy, air;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && air[nx][ny] == 0) {
                air[nx][ny] = 3;
                DFS(nx,ny);
            }

        }

    }
    public static void main(String[] args) throws IOException {
        Main P = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M]; // 변화시키는 배열
        copy = new int[N][M]; // 카피 배열
        air = new int[N][M]; // 공기 배열

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a =  Integer.parseInt(st.nextToken());
                arr[i][j] = a;
                copy[i][j] = a;
                air[i][j] = a;
            }
        }

        for (int i = 0; i < M; i++) {
            air[0][i] = 3;
            air[N-1][i] = 3;
        }
        for (int i = 0; i < N; i++) {
            air[i][0] = 3;
            air[i][M-1] = 3;
        }



        while(true) {
            time++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(air[i][j] == 3) {
                        P.DFS(i,j);
                    }

                }
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(copy[i][j] == 1) {
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if(nx >= 0 && nx < N && ny >= 0 && ny < M && copy[nx][ny] == 0 && air[nx][ny] == 3) {
                                arr[i][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j] == 1) {
                        flag = true;
                    }
                }
            }
            if(!flag) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if(copy[i][j] == 1) {
                            count++;
                        }
                    }
                }
                System.out.println(time);
                System.out.println(count);
                break;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copy[i][j] = arr[i][j];
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j] == 0 && air[i][j] == 1) {
                        air[i][j] = 0;
                    }

                }

            }

        }


    }
}