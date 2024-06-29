#include <stdio.h>
int main()
{
	int seat[101] = { 0, };
	int N;
	int num;
	int reject = 0;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &num);
		seat[num]++;
		if (seat[num] > 1) {
			reject++;
			seat[num] = 1;
		}
	}
	printf("%d", reject);
}