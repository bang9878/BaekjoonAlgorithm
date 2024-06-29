#include <stdio.h>
int main()
{
	int n, k;
	int arr[1001];
	int cnt = 0;
	int res;
	scanf("%d %d", &n, &k);
	for (int i = 2; i <= n; i++) {
		arr[i] = 1;
	}
	for (int i = 2; i <= n; i++) {
		for (int j = i; j <= n; j += i) {
			if (arr[j] == 0)continue;
			arr[j] = 0;
			++cnt;
			if (cnt == k) {
				res = j;
				break;
			}
		}
	}
	printf("%d", res);
}