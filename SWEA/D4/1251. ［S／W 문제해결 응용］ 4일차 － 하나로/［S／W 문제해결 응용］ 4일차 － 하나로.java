import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution {

    static class Edge implements Comparable<Edge> {
        int u, v;
        long distSq; 

        Edge(int u, int v, long distSq) {
            this.u = u;
            this.v = v;
            this.distSq = distSq;
        }

        // 거리의 제곱 기준으로 오름차순 정렬
        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.distSq, o.distSq);
        }
    }

    static int[] parent;

    // Union-Find: 루트 노드 찾기 (경로 압축)
    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    // Union-Find: 두 집합 합치기
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
            return true;
        }
        return false;
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            long[] xPos = new long[N];
            long[] yPos = new long[N];

            for (int i = 0; i < N; i++) {
                xPos[i] = sc.nextLong();
            }

            for (int i = 0; i < N; i++) {
                yPos[i] = sc.nextLong();
            }

            double E = sc.nextDouble();

            List<Edge> edgeList = new ArrayList<>();

            // 모든 섬 간의 간선 생성
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    long dx = xPos[i] - xPos[j];
                    long dy = yPos[i] - yPos[j];
                    long distSq = dx * dx + dy * dy;

                    edgeList.add(new Edge(i, j, distSq));
                }
            }

            // 간선 가중치(거리의 제곱) 오름차순 정렬
            Collections.sort(edgeList);

            // Union-Find 배열 초기화
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            long totalDistSq = 0;
            int count = 0;

            // 크루스칼 알고리즘 수행
            for (Edge edge : edgeList) {
                if (union(edge.u, edge.v)) {
                    totalDistSq += edge.distSq;
                    count++;
                    // N개의 섬을 연결하는 간선의 개수는 N-1개
                    if (count == N - 1) break;
                }
            }

            long ans = Math.round(totalDistSq * E);

            System.out.println("#" + test_case + " " + ans);
        }

        sc.close();
    }
}