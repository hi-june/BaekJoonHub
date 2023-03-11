import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;
            
            List<Integer> nums = new ArrayList<>(); // 약수들을 담을 리스트

            int sqrt = (int)Math.sqrt(n);   // 제곱수
            for (int i = 1; i <= sqrt; i++) {
                if (n % i == 0) {
                    nums.add(i);    // 약수 중 작은 수
                    if (n / i != i) {  // 제곱근 두 번 추가 방지
                        nums.add(n / i);    // 약수 중 큰 수
                    }
                }
            }
            Collections.sort(nums); // 약수 모음 오름차순 정렬
            nums.remove(nums.size() - 1);   // 맨 마지막 수(자기 자신) 제거

            int sum = nums.stream().mapToInt(i -> i.intValue()).sum();  // 자기 자신을 제외한 약수들의 총 합
            
            String result;
            if (sum == n) {
                String sumString = nums.stream()    // Stream<Integer>
                    .map(i -> i.toString()) // Stream<String>
                    .collect(Collectors.joining(" + "));    // "1 + 2 + 3"
                result = n + " = " + sumString + "\n";
                bw.write(result);
            } else {
                result = n + " is NOT perfect.\n";
                bw.write(result);
            }
        }
        bw.flush();
        bw.close();
    }
}