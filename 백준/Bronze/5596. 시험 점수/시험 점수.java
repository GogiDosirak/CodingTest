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

       int min = sc.nextInt() + sc.nextInt() + sc.nextInt() + sc.nextInt();
       int man = sc.nextInt() + sc.nextInt() + sc.nextInt()+ sc.nextInt();
       
       if(min > man) {
           System.out.println(min);
       } else {
           System.out.println(man);
       }
       


    }
}