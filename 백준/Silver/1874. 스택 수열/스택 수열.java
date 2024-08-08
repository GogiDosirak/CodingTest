import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int T = Integer.parseInt(br.readLine());
        int value = 1;
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = value; j <= n; j++) {
                stack.push(j);
                sb.append('+').append('\n');
                value = n+1;
            }
            if(stack.peek() == n) {
                sb.append('-').append('\n');
                stack.pop();
            } else {
                System.out.println("NO");
                return;
            }


        }
        System.out.println(sb);
        }
    }

