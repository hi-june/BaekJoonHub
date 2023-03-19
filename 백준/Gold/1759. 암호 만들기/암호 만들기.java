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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<String> alphabet =
                Arrays.stream(br.readLine().split(" "))
                        .sorted()
                        .collect(Collectors.toList());

        Combination<String> comb = new Combination<>(c, l);
        comb.combination(alphabet, 0, 0, 0);

        List<List<String>> result = comb.getResult();
        result.forEach(Collections::sort);

        String[] vowel = {"a", "e", "i", "o", "u"};
        for (List<String> key : result) {
            int count = 0;  // 모음의 개수 세기

            for (String v : vowel) {
                count += Collections.frequency(key, v);
            }

            if (count >= 1 && key.size() - count >= 2) {    // 모음과 자음의 갯수가 조건을 만족하는 경우에만
                String code = key.stream().collect(Collectors.joining(""));
                bw.write(code + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}