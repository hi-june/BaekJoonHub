import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지방의 수
        int n = Integer.parseInt(br.readLine());

        // 예산 요청
        int[] budgetRequest = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 전체 예산
        int totalBudget = Integer.parseInt(br.readLine());


        int remainBudget = totalBudget;
        int diffBudget = 0;
        int possibleMaxBudget = 0;
        int prevBudget = 0;
        Arrays.sort(budgetRequest);

        for (int i = 0; i < n; i++) {
            diffBudget = budgetRequest[i] - prevBudget; // 현재 최소

            int num = n - i;    // 남은 예산 개수

            if (remainBudget - (diffBudget * num) < 0) {    // 예산이 부족한 경우
                int share = remainBudget / num;
                possibleMaxBudget = prevBudget + share;
                System.out.println(possibleMaxBudget);
                return;
            }

            remainBudget = remainBudget - (diffBudget * num);
            prevBudget = budgetRequest[i];
        }

        possibleMaxBudget = budgetRequest[n-1];
        System.out.println(possibleMaxBudget);
    }
}