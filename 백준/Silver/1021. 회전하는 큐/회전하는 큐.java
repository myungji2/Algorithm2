import java.io.*;
import java.util.*;

class Main {
    static Deque<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            q.addLast(i);
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int answer = 0;

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st2.nextToken());
            
            int index = findIndex(target);
            if (index <= q.size() / 2) {
                answer += rotateLeft(index);

            } else {
                answer += rotateRight(q.size() - index);

            }
            q.pollFirst(); // Remove the target element after bringing it to the front
        }

        bw.append(String.valueOf(answer)).append('\n');
        bw.flush();
        bw.close();
        br.close();
    }

    public static int findIndex(int target) {
        int index = 0;
        for (int value : q) {
            if (value == target) {
                break;
            }
            index++;
        }
        return index;
    }

    public static int rotateLeft(int steps) {
        for (int i = 0; i < steps; i++) {
            q.addLast(q.pollFirst());
        }
        return steps;
    }

    public static int rotateRight(int steps) {
        for (int i = 0; i < steps; i++) {
            q.addFirst(q.pollLast());
        }
        return steps;
    }
}
