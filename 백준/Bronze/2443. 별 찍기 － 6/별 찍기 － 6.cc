#include <stdio.h>
int main()
{
	int i, j, k;
	int n;
	scanf("%d", &n);
	for (k = 1; k <= n; k++)
	{
		for (j = 1; j < k; j++)
		{
			printf(" ");
		}

		for (i = 1; i <= 2 * n - (2 * k - 1); i++)
		{
			printf("*");
		}
	
		printf("\n");
	}
}