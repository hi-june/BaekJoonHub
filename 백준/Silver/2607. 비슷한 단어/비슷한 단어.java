import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 기준 문자열의 알파벳 초기화
        int[] alphabet = new int[26];
        String sourceWord = br.readLine();  // 기준 문자열

        for (int i = 0; i < sourceWord.length(); i++) {
            int idx = sourceWord.charAt(i) - 'A';

            alphabet[idx] += 1;
        }

        // 비교 문자열 초기화
        String[] words = new String[N - 1];

        for (int i = 0; i < N - 1; i++) {
            words[i] = br.readLine();
        }


        // 기준 문자열과 비교
        int similarCount = 0;   // 비슷한 문자열의 갯수

        for (String word : words) {
            // 두 문자열의 길이 차이가 1보다 크면 비슷한 문자열이 될 수 없음
            if (Math.abs(sourceWord.length() - word.length()) > 1) continue;

            // 겹치는 알파벳 개수 세기
            int[] tmpAlphabet = alphabet.clone();
            int count = 0;

            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'A';

                if (tmpAlphabet[idx] > 0) {
                    count += 1;
                    tmpAlphabet[idx] -= 1;
                }
            }

            // 1. 비교 문자열의 길이 = 기준 문자열의 길이 - 1
            // 나머지는 다 같고, 하나를 더해서 해결
            if (word.length() == sourceWord.length() - 1) {
                if (count == word.length()) similarCount += 1;
            }

            // 2. 비교 문자열의 길이 = 기준 문자열의 길이 + 1
            // 나머지는 다 같고, 하나를 빼서 해결
            else if (word.length() == sourceWord.length() + 1) {
                if (count == sourceWord.length()) similarCount += 1;
            }

            // 3. 비교 문자열의 길이 == 기준 문자열의 길이
            else if (word.length() == sourceWord.length()) {
                // 동일한 구성일 경우
                if (count == sourceWord.length()) similarCount += 1;

                // 하나를 수정해서 해결 가능한 경우
                else if (count == sourceWord.length() - 1) similarCount += 1;
            }
        }

        bw.write(similarCount + "");
        bw.flush();
        bw.close();

        br.close();
    }
}