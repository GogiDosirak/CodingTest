import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Node {
    char v;
    Node lt, rt;

    public Node(char v) {
        this.v = v;
        lt = rt = null;
    }
}
public class Main {
    static int N;
    static Node[] tree;
    public void pre(Node root) {
        if(root == null) {
            return;
        } else {
            System.out.print(root.v);
            pre(root.lt);
            pre(root.rt);
        }
    }

    public void mid(Node root) {
        if(root == null) {
            return;
        } else {
            mid(root.lt);
            System.out.print(root.v);
            mid(root.rt);
        }
    }

    public void post(Node root) {
        if(root == null) {
            return;
        } else {
            post(root.lt);
            post(root.rt);
            System.out.print(root.v);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new Node[N+1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0); // 부모노드
            char b = st.nextToken().charAt(0); // 왼쪽자식
            char c = st.nextToken().charAt(0); // 오른쪽 자식

            if(tree[a-'A'] == null) { // 부모 노드가 없는 경우
                tree[a-'A'] = new Node(a);
            }
            if(b != '.') { // 왼쪽 자식이 존재할 경우
                tree[b-'A'] = new Node(b); // 왼쪽 노드를 만들고
                tree[a-'A'].lt = tree[b-'A']; // 부모 노드와 연결
            }
            if(c != '.') {
                tree[c-'A'] = new Node(c);
                tree[a-'A'].rt = tree[c-'A'];
            }
        }
        T.pre(tree[0]);
        System.out.println();
        T.mid(tree[0]);
        System.out.println();
        T.post(tree[0]);

    }
}

