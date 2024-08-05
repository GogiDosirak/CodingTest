import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class docu {
    int priority;
    int location;

    public docu(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int cnt = 0;
            Queue<docu> Q = new LinkedList<>();
            int N = sc.nextInt();
            int M = sc.nextInt();
            for (int j = 0; j < N; j++) {
                Q.offer(new docu(sc.nextInt(),j));
            }
            while(!Q.isEmpty()) {
                    docu a  = Q.poll();
                    boolean flag = true;
                    for(docu b : Q) {
                        if(b.priority > a.priority) {
                            Q.offer(a);
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        if (a.location == M) {
                            cnt++;
                            System.out.println(cnt);
                            break;
                        } else {
                            cnt++;
                        }
                    }

                }


            }

        }


    }

