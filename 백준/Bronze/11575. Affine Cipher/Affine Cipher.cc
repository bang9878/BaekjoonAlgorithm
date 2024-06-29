#include <stdio.h>
int main()
{
	int a, b, T, i, j;
	int X, res;
	char str[1000001];
	scanf("%d", &T);
	for (i = 0; i < T; i++) {
		scanf("%d %d", &a, &b);
		scanf("%s", str);
		for (j = 0; str[j] != '\0'; j++) {
			X = str[j] - 'A';
			res = (a*X + b) % 26;
			printf("%c", res + 'A');
		}
		printf("\n");
	}

}