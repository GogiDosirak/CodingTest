import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.YearMonth;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a == 0 && b == 0) {
                break;
            }
            if(a > b) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }










    }
}