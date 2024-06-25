import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        
        while(true) {
            s = br.readLine();
            if(s.equals(".")) {
                break;
            }
            sb.append(stack(s)).append('\n');
        }

        System.out.println(sb);


    }

    public static String stack(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(' || c == '[') {
                stack.push(c);
            }

            else if(c == ')') {
                //닫는 소괄호가 왔는데 비어있거나, [가 있어서 매칭이 안되는 경우
                // ([]) 이경우는 스택의 특성상 []가 먼저 빠져나감 -> yes
                // ([)] 이경우는 [가 남아있어 매칭이 안됨 -> no
                if(stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            }

            else if(c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
                }
            }

        if(stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }


    }
}