import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    int answer = 0;
    ArrayList<Integer> arr = new ArrayList<>();
    boolean flag = false;
    public void solve(int A, int P) {
        if(flag) {
            return;
        }
        if(arr.contains(A)) {
            flag = true;
            answer = arr.indexOf(A);
            System.out.println(answer);
        } else {
            arr.add(A);
            int nx = 0;
            while(A != 0) {
                nx += (int) Math.pow(A%10, P);
                A = A/10;
            }
            solve(nx,P);
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int P = sc.nextInt();
        T.solve(A,P);



    }
}
