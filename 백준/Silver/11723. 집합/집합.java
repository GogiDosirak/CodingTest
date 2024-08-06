import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] ha = br.readLine().split(" ");
                if (ha[0].equals("add")) {
                    int x = Integer.parseInt(ha[1]);
                    if (!arr.contains(x)) {
                        arr.add(x);
                    }
                } else if (ha[0].equals("check")) {
                    int x = Integer.parseInt(ha[1]);
                    if (arr.contains(x)) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }

                } else if (ha[0].equals("remove")) {
                    int x = Integer.parseInt(ha[1]);
                    if (arr.contains(x)) {
                        arr.remove(Integer.valueOf(x)); // int로 하면 index, Integer로 하면 값
                    }
                } else if (ha[0].equals("toggle")) {
                    int x = Integer.parseInt(ha[1]);
                    if (arr.contains(x)) {
                        arr.remove(Integer.valueOf(x));
                    } else {
                        arr.add(x);
                    }
                }
                if(ha[0].equals("all")) {
                    arr.clear();
                    for (int j = 1; j <= 20; j++) {
                        arr.add(j);
                    }
                } else if(ha[0].equals("empty")) {
                    arr.clear();
                }


        }
        System.out.println(sb);



        }
    }

