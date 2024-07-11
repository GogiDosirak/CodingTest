import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            if(a == 1) {
                stack.push(sc.nextInt());
            } else if(a == 2) {
                if(stack.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(stack.pop()).append('\n');
                }
            } else if(a == 3) {
                sb.append(stack.size()).append('\n');
            } else if(a == 4) {
                if(stack.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if(a == 5) {
                if(stack.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(stack.peek()).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}