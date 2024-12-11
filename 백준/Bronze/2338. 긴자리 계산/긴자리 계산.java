import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.*;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new InputStreamReader(System.in));


        BigInteger A = new BigInteger(sc.next());
        BigInteger B = new BigInteger(sc.next());

        System.out.println(A.add(B));
        System.out.println(A.subtract(B));
        System.out.println(A.multiply(B));




    }
}