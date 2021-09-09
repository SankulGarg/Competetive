
public class Travel {

	int memo[][] = null;

	public int campWays(int k, int[] arr, int start, int target) {
		memo = new int[arr.length + 1][k + 1];
		dfs(arr, start, target, k);
		return memo[start][k];

	}

	int dfs(int[] arr, int curr, int target, int k) {
		if (curr == target)
			return 1;
		if (k <= 0)
			return 0;

		if (memo[curr][k] != 0)
			return memo[curr][k];

		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i != curr) {
				result += dfs(arr, i, target, k - Math.abs(arr[curr] - arr[i]));
			}
		}

		memo[curr][k] = result;
		return memo[curr][k];

	}

	public static void main(String[] args) {
		System.out.println(new Travel().campWays(5, new int[] { 2, 3, 6, 8, 4 }, 1, 3));
	}
}
