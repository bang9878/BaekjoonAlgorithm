#include <stdio.h>
int main()
{
	int i, j,n;
	scanf("%d", &n);
	for (i = 1; i <= n; i++) {
		for (j = 0; j < i; j++)
			printf("*");
		for (j = 2 * n; j > 2 * i; j--)
			printf(" ");
		for (j = 0; j < i; j++)
			printf("*");
		printf("\n");
	}
	for (i = 1; i <= n-1; i++) {
		for (j = i; j < n; j++)
			printf("*");
		for (j = 0; j < 2 * i; j++)
			printf(" ");
		for (j = i; j < n; j++)
			printf("*");
		printf("\n");
	}
}