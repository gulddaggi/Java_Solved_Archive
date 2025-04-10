import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 키 입력
        int key = Integer.parseInt(br.readLine());

        // 암호화된 문장 입력
        String line = br.readLine();

        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                // 복호화 수행
                int shift = (ch - 'a' - key + 26) % 26;
                decrypted.append((char) ('a' + shift));

                // 키 증가 및 25 넘어가면 1로 순환
                key++;
                if (key > 25) key = 1;
            } else {
                // 문자 그대로 추가
                decrypted.append(ch);
            }
        }

        System.out.println(decrypted.toString());
    }
}
