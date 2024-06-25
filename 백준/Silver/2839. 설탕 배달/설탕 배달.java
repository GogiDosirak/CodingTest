import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        // 5로 먼저 나누고 3으로 나누기 보단,
        // 3으로 계속 빼주다가, 5로 나눌 수 있다면 5로 나누면 됨
        while(N > 2) {
            if(N % 5 == 0) {
                answer += N/5;
                break;
            }
            N -= 3;
            answer++;
            if(N < 5 && N % 3 != 0) {
                answer = -1;
                break;
            }
        }

        System.out.println(answer);



    }
}
