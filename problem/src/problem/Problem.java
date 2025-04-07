package problem;

import java.io.*;
import java.util.*;

class Micro {
    int row, col, count, direction;

    public Micro(int row, int col, int count, int direction) {
        this.row = row;
        this.col = col;
        this.count = count;
        this.direction = direction;
    }
}

public class Problem {

    // 0: 상, 1: 하, 2: 좌, 3: 우
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 셀 크기
            int M = Integer.parseInt(st.nextToken()); // 시간
            int K = Integer.parseInt(st.nextToken()); // 군집 수

            List<Micro> micros = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken()) - 1;

                micros.add(new Micro(row, col, count, direction));
            }

            while (M-- > 0) {
                // 좌표 기준으로 미생물 리스트 저장
                Map<String, List<Micro>> map = new HashMap<>();

                // 이동
                for (Micro m : micros) {
                    m.row += dRow[m.direction];
                    m.col += dCol[m.direction];

                    // 약품 셀인 경우 처리
                    if (m.row == 0 || m.row == N - 1 || m.col == 0 || m.col == N - 1) {
                        m.count /= 2;

                        // 방향 반대로
                        if (m.direction == 0) m.direction = 1;
                        else if (m.direction == 1) m.direction = 0;
                        else if (m.direction == 2) m.direction = 3;
                        else if (m.direction == 3) m.direction = 2;
                    }

                    if (m.count == 0) continue;

                    String key = m.row + "," + m.col;
                    map.putIfAbsent(key, new ArrayList<>());
                    map.get(key).add(m);
                }

                // 병합
                List<Micro> nextMicros = new ArrayList<>();
                for (List<Micro> list : map.values()) {
                    if (list.size() == 1) {
                        nextMicros.add(list.get(0));
                    } else {
                        int total = 0;
                        int max = 0;
                        int direction = 0;

                        for (Micro m : list) {
                            total += m.count;
                            if (m.count > max) {
                                max = m.count;
                                direction = m.direction;
                            }
                        }
                        Micro merged = new Micro(list.get(0).row, list.get(0).col, total, direction);
                        nextMicros.add(merged);
                    }
                }

                micros = nextMicros;
            }

            int answer = 0;
            for (Micro m : micros) {
                answer += m.count;
            }

            System.out.println("#" + testCase + " " + answer);
        }
    }
}
