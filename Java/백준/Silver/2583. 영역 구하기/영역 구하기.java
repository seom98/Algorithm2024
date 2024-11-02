import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[][] arr;
	static int[] drow = { -1, 1, 0, 0 };
	static int[] dcol = { 0, 0, -1, 1 };
	static int danji = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[N][M];
		int K = sc.nextInt();
		for (int k = 0; k < K; k++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			for (int i = a; i < c; i++) {
				for (int j = b; j < d; j++) {
					arr[i][j] = 1;
				}
			}
		}
		int count = 0;
		List<Integer> danjis = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					count++;
					DFS(i, j);
					danjis.add(danji);
					danji = 0;
				}
			}
		}
		Collections.sort(danjis);
		System.out.println(count);
		for (int ele : danjis) {
			System.out.print(ele + " ");
		}
		sc.close();
	}
	static void DFS(int i, int j) {
		danji++;
		arr[i][j] = 1;
		
		for (int d = 0; d < 4; d++) {
			int x = i + drow[d];
			int y = j + dcol[d];

			if (x >= 0 && x < N && y >= 0 && y < M && arr[x][y] == 0)
				DFS(x, y);
		}
	}
}