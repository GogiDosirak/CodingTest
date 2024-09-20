import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class jump {
    int x1;
    int x2;

    public jump(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}
public class Main {
    static int N,M,L;
    static int[] arr,ch;
    static ArrayList<jump> go;
    int[] dx = {1,2,3,4,5,6};
    public void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v);
        ch[v] = 1;
        while(!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                if (x == 100) {
                    System.out.println(L);
                    return;
                }
                for (int j = 0; j < 6; j++) {
                    int nx = x + dx[j];
                    if(nx <= 100 && ch[nx] == 0 ) {
                        ch[nx] = 1;
                        for (jump jmp : go) {
                            if (jmp.x1 == nx) {
                                nx = jmp.x2;
                                break;
                            }
                        }
                        Q.offer(nx);
                    }

                }
            }
            L++;
        }

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[101];
        ch = new int[101];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        go = new ArrayList<>();
        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            go.add(new jump(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        T.BFS(1);

    }
}



