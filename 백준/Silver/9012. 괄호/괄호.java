import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb.append(stack(br.readLine())).append('\n');
        }
        System.out.println(sb);
        }
    // (와 )의 짝이 맞아야하고, 대신 ( 뒤에 )가 위치해야함 ex) )))((( x
    // 스택에 (를 넣고, 그 뒤에 )가 존재하는 경우 빼줌 -> 마지막에 스택이 안남아있으면 YES
    // 스택에 (가 남아있으면 여분의 )가 존재하는 것이므로 NO
        public static String stack(String s) {
        Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if(c == '(') {
                    stack.push('(');
                }
                else if(stack.isEmpty()) { // 비어있다면 (보다 )가 많은 것이므로 NO 출력 -> )로 먼저 시작해도 NO 출력
                    return "NO";
                } else if(c == ')') { // 그외의 경우. 즉 )라면 ( pop
                    stack.pop();
                }
            }

            if(stack.isEmpty()) {
                return "YES";
            } else {
                return "NO";
            }

        }

        }




