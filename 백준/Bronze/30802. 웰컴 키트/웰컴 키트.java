import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[] size = new int[6];
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < 6; i++) {
            size[i] = sc.nextInt();
        }
        sc.nextLine();
        int T = sc.nextInt();
        int P = sc.nextInt();

        int answer = 0;

        for (int i = 0; i < 6; i++) {
            if(size[i] % T == 0) {
               answer = answer + size[i]/T;
            }
            else {
                answer = answer + (size[i] / T + 1);
            }
        }
        System.out.println(answer);
        System.out.print(N/P + " " + N%P);



    }
}
