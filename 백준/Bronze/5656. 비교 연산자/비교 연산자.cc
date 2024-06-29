#include <stdio.h>
#include <string.h>
int main()
{
	char cmp[10];
	int a, b;
	int res[12000];
	int i = 0;
	while (1) {
		scanf("%d %s %d", &a, cmp, &b);
		if (strcmp(cmp, ">") == 0)res[i] = a > b;
		else if (strcmp(cmp, ">=") == 0)res[i] = a >= b;
		else if (strcmp(cmp, "<") == 0)res[i] = a < b;
		else if (strcmp(cmp, "<=") == 0)res[i] = a <= b;
		else if (strcmp(cmp, "!=") == 0)res[i] = a != b;
		else if (strcmp(cmp, "==") == 0)res[i] = a == b;
		else if (strcmp(cmp, "E") == 0)break;
		printf("Case %d: ", i + 1);
		if (res[i] == 1)printf("true\n");
		else if (res[i] == 0)printf("false\n");
		i++;
	}
}