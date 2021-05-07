class Solution {
  public int[][] reconstructQueue(int[][] people) {
	Arrays.sort(people, (int[] a, int[] b)->{
		if (a[0] == b[0]) {
			return a[1] - b[1];
		}
		return b[0] - a[0];
	});
	ArrayList<int[]> temp = new ArrayList<>();
	for (int[] ar : people) {
		temp.add(ar[1], ar);
	}
	int[][] ans = new int[people.length][2];
	int i = 0;
	for (int[] a : temp) {
		ans[i][0] = a[0];
		ans[i++][1] = a[1];
	}
	return ans;
}
}
