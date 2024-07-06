
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int cnt = 0;
        boolean st = false;
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            ArrayList<Character> arr = new ArrayList<>();
            if(s.length() != 1) {
                for (int j = 1; j < s.length(); j++) {
                    st = true;
                    arr.add(s.charAt(0));
                    char c = s.charAt(j);
                    if (arr.contains(c)) {
                        if (s.charAt(j - 1) != c) {
                            st = false;
                            break;
                        }

                    }
                    arr.add(c);
                }
            } else {
                st = true;
            }
            if(st) {
                cnt++;
            }

        }
        System.out.println(cnt);

    }
}