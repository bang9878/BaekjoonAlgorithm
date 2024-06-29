#include <stdio.h>
int main()
{
	int num[3];
	int i, max = 0, min = 101, mid;
	for (i = 0; i < 3; i++) {
		scanf("%d", &num[i]);
		if (max < num[i])max = num[i];
		if (min > num[i])min = num[i];
	}
	for (i = 0; i < 3; i++) {
		if (num[i] != max && num[i] != min) {
			mid = num[i];
		}
	}
	if (num[0] == num[1]) mid = num[0];
	else if (num[0] == num[2])mid = num[0];
	else if (num[1] == num[2]) mid = num[1];

	printf("%d", mid);
	
}