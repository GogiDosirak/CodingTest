import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Abs implements Comparable<Abs>{
    int v;
    char pm;
    public Abs(int v, char pm) {
        this.v = v;
        this.pm = pm;
    }
    @Override
    public int compareTo(Abs ob) {
        if(this.v != ob.v) {
            return this.v - ob.v;
        } else {
            return this.pm - ob.pm;
        }

    }
}
public class Main {


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Abs> pQ = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a == 0 && pQ.isEmpty()) {
                sb.append(0).append('\n');
                continue;
            }
            if(a == 0) {
                Abs b = pQ.poll();
                if(b.pm == 'p') {
                    sb.append(b.v).append('\n');
                    continue;
                } else {
                    sb.append(-b.v).append('\n');
                    continue;
                }
            }
            if(a > 0) {
                pQ.offer(new Abs(Math.abs(a), 'p'));
            }
            if(a < 0) {
                pQ.offer(new Abs(Math.abs(a),'m'));
            }
        }

        System.out.println(sb);


    }
}

