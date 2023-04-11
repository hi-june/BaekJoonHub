import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String doc = br.readLine();  // 원본 문자열
        String word = br.readLine();  // 검색 대상
        int count = 0;

        // index를 증가시켜가며 비교함
        int idx = 0;
        int wordLen = word.length();
        while (idx <= doc.length() - wordLen) {
            if (doc.substring(idx, idx + wordLen).equals(word)) {
                count += 1;
                idx += wordLen;   // 찾으면 탐색 index를 target의 길이만큼 증가시킴
            } else {
                idx += 1;
            }
        }

        System.out.println(count);
    }
}