import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            bw.write(Integer.toString(0));
            bw.flush();

            br.close();
            bw.close();
            return;
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) primes.add(i);
        }

        int s = 0;
        int e = s;

        int count = 0;
        int sum = primes.get(e);
        while (s <= e) {
            if (sum >= N) {
                if (sum == N) count++;

                sum -= primes.get(s);
                s++;
            } else if (e < primes.size() - 1) {
                e++;
                sum += primes.get(e);
            } else {
                break;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean isPrime(int n) {
        int sqrt = (int)Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}