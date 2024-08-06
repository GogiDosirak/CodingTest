import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                 pQ.offer(sc.nextInt());
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if(!pQ.isEmpty()) {
                answer = pQ.poll();
            }

        }
        System.out.println(answer);


        }


    }

