import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            if(st.nextToken().contains("push")) {
                q.offer(Integer.parseInt(st.nextToken()));
            } else if(s.equals("front")) {
                if(!q.isEmpty()) {
                    sb.append(q.peek()).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            } else if(s.equals("pop")) {
                if(!q.isEmpty()) {
                    sb.append(q.poll()).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            } else if(s.equals("size")) {
                sb.append(q.size()).append('\n');
            } else if(s.equals("empty")) {
                if(!q.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(1).append('\n');
                }
            } else if(s.equals("back")) {
                if(!q.isEmpty()) {
                    sb.append(q.get(q.size()-1)).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }

            }

        }
        System.out.println(sb);

    }
}