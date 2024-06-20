import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        sc.nextLine();

        int[] array1 = new int[10000001]; // 양수
        int[] array2 = new int[10000001]; // 음수

        // 카운팅 정렬? -> 음수는 안됨 => 음수방향 카운팅도 하나 만들기
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            if(a > 0) {
                array1[a]++;
            } else {
                array2[Math.abs(a)]++; // - 떼서 ++
            }
        }
        sc.nextLine();


        int M = sc.nextInt();
        sc.nextLine();
        int[] array3 = new int[M];
        for (int i = 0; i < M; i++) {
            array3[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            if(array3[i] > 0) {
                sb.append(array1[array3[i]]).append('\n');
            } else {
                sb.append(array2[Math.abs(array3[i])]).append(" ");
            }
        }
        System.out.println(sb);



        }



        }


