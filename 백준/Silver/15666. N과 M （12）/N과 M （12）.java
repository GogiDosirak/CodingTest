import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] pm;
    static ArrayList<Integer> arr;
    public void solve(int v, int L) {
        if(L == M) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = v; i < arr.size(); i++) {
                pm[L] = arr.get(i);
                solve(i, L+1);
            }

        }

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        arr = new ArrayList<>(set);
        pm = new int[M];
        Collections.sort(arr);
        T.solve(0,0);





    }
}

