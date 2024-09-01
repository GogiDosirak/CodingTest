import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public long remainder(long A, long B, long C) {
        if (B == 1) { // 지수가 1인 경우
            return A % C;
        } else {
            long halfVal = remainder(A, B/2, C); // 지수를 두개로 쪼갬
            // 지수가 홀수일 때
            if (B % 2 == 1) {
                return (halfVal % C * halfVal % C) * A % C;
            } 
            return halfVal % C * halfVal % C;
        }

    }
    public static void main(String[] args) throws IOException {
        Main P = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        System.out.println(P.remainder(A,B,C));
        }
    }


