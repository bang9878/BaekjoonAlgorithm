#include <stdio.h>

int main()
{
	int t, j, i, k, s;
	int line;
	scanf("%d", &t);
	for (i = 0; i < t; i++)
	{
		scanf("%d", &line);
		for (s = 0; s < line; s++) {
			printf("#");
		}
		printf("\n");
		for (j = 0; j < line-2; j++) {
			if (j != 0 || (j + 1) != line)
				printf("#");
			for (k = 0; k < line-2; k++) {
				
				printf("J");
			}
			printf("#");
			printf("\n");
		}
		if (line != 1) {
			for (s = 0; s < line; s++)printf("#");
			printf("\n");
		}
		printf("\n");
	}
}