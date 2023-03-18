import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n));
    }

    public static int fibo(int n) {
        int fibo0 = 0;
        int fibo1 = 1;

        if (n == 0) return fibo0;
        if (n == 1) return fibo1;

        return fibo(n - 2) + fibo(n - 1);
    }
}