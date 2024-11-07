import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.YearMonth;
import java.util.*;

class Person {
    String name;
    int age;
    int weight;

    public Person(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> list = new ArrayList<>();
        while(true) {
            String a = sc.next();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a.equals("#")) {
                break;
            }
            list.add(new Person(a,b,c));
        }

        for(Person p : list) {
            if(p.age > 17 || p.weight >= 80) {
                System.out.print(p.name + " Senior" );
            } else {
                System.out.print(p.name + " Junior");
            }
            System.out.println();
        }










    }
}