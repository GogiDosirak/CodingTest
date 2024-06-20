import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        // nCk = n! / r!(n-r)!
        System.out.println(factorial(N) / (factorial(K)*(factorial(N-K))));
    }
    public static int factorial(int N) {
        if(N == 0) {
            return 1;
        }
        return N * factorial(N-1);
        // 팩토리얼은 N*(N-1)! , factorial(N)을 하게되면 무한재귀에 빠짐
    }
}
