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

        String s = sc.nextLine();

        if(s.contains("M")&& s.contains("O") && s.contains("B") && s.contains("I") && s.contains("S")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }



    }
}