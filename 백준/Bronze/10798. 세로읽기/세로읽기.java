import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] board = new String[5];
        for (int i = 0; i < board.length; i++) {
            board[i] = br.readLine();
        }
        
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j].length() - 1 < i) continue;
                bw.write(board[j].substring(i, i+1));
            }
        }
        
        bw.flush();
        bw.close();
    }
}