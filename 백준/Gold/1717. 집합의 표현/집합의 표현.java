import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[] unf;
    public int Find(int v) {
        if(v == unf[v]) {
            return v;
        } else {
            return unf[v] = Find(unf[v]);
        }

    }
    public void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) {
            unf[fa] = unf[fb];
        }


    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        unf = new int[n+1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            if(t == 0) {
                T.Union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if(T.Find(b) == T.Find(c)) {
                    sb.append("YES").append('\n');

                } else {
                    sb.append("NO").append('\n');
                }
            }

        }
        System.out.println(sb);




        }
    }

