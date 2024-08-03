import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M, len;
    static int[][] arr;
    static ArrayList<Point> chicken = new ArrayList<>();
    static ArrayList<Point> home = new ArrayList<>();
    static int[] combi;
    static int answer = Integer.MAX_VALUE;
    public void combination(int L, int S) {
        if(L == M) {
            // 조합된 배열을 가지고 거리구하기
            int totalD = 0;
            for (int i = 0; i < home.size(); i++) {
                int chicD = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    chicD = Math.min(chicD, Math.abs(home.get(i).x - chicken.get(combi[j]).x) + Math.abs(home.get(i).y - chicken.get(combi[j]).y));
                }
                totalD += chicD;
            }
            answer = Math.min(answer,totalD);

        } else {
            for (int i = S; i < len; i++) {
                combi[L] = i;
                combination(L+1,i+1);
            }

        }


    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    home.add(new Point(i,j));
                }
                if(arr[i][j] == 2) {
                    chicken.add(new Point(i,j));
                }
            }
        }
        combi = new int[M];
        // 치킨집을 가지고 조합수를 구해야한다.
        len = chicken.size();
        T.combination(0,0);
        System.out.println(answer);



    }
}
