import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.*;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[N];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
        sc.nextLine();
        
        String target = sc.nextLine();

        for (int i = 0; i < N; i++) {
            if(target.equals(arr[i])) {
                cnt++;
            }
            
        }

        System.out.println(cnt);



    }
}