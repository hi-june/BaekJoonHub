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
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> ingredientList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> ingredient = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            ingredientList.add(ingredient);
        }

        List<Integer> diff = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            Combination comb = new Combination<>(n, i);
            comb.combination(ingredientList, 0, 0, 0);

            List<List<List<Integer>>> chosenIngredient = comb.getResult();

            for (List<List<Integer>> choice : chosenIngredient) {
                int sour = 1;
                int bitter = 0;

                for (List<Integer> ingredient : choice) {
                    sour *= ingredient.get(0);
                    bitter += ingredient.get(1);
                }
                diff.add(Math.abs(sour - bitter));
            }
        }

        int minimum = Collections.min(diff);
        System.out.println(minimum);
    }
}