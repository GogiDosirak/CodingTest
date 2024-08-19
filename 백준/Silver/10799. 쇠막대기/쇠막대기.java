import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String s = br.readLine();
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push('(');
            }
            if(c == ')') {
                if(s.charAt(i-1) == '(') {
                    if(!stack.isEmpty()) {
                        stack.pop();
                        answer += stack.size();
                    }
                } else {
                    answer += 1;
                    stack.pop();
                }
            }
        }
        System.out.println(answer);
    }
}

