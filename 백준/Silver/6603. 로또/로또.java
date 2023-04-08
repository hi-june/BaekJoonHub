import java.io.*;
import java.util.*;
import java.util.stream.*;

class Combination<T> {
    private int n;
    private int r;
    private int[] now; // 현재 조합
    private List<List<T>> result; // 모든 조합

    public List<List<T>> getResult() {
        return result;
    }

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<>();
    }

    public void combination(List<T> list, int depth, int index, int target) {
        if (depth == r) {
            List<T> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(list.get(now[i]));
            }
            result.add(temp);
            return;
        }
        if (target == n) return;
        now[index] = target;
        combination(list, depth + 1, index + 1, target + 1);
        combination(list, depth, index, target + 1);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                bw.flush();
                bw.close();
                break;
            }

            List<String> lotto = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                String  num = st.nextToken();
                lotto.add(num);
            }

            Combination<String> comb = new Combination<>(k, 6);
            comb.combination(lotto, 0, 0, 0);

            List<List<String>> result = comb.getResult();

            for (List<String> lottoCase : result) {
                String answer = lottoCase.stream().collect(Collectors.joining(" "));
                bw.write(answer + "\n");
            }
            bw.write("\n");
        }
    }
}