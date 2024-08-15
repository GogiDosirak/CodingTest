import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            double m = Double.parseDouble(st.nextToken());
            if(n == 0 && m == 0.00) {
                break;
            }
            m *= 100;
            m += 0.5;
            int[] dy = new int[(int)m+1];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                double p = Double.parseDouble(st.nextToken());
                p *= 100;
                p += 0.5;
                for (int j = (int)p; j < m; j++) {
                    dy[j] = Math.max(dy[j], dy[j - (int)p] + c);
                }

            }
            sb.append(dy[(int)m]).append('\n');

        }
        System.out.println(sb);
    }
}

