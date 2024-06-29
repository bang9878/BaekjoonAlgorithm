#include <stdio.h>
#include <string.h>
int main()
{
	char str[1000];
	int T, i, len;
	scanf("%d", &T);
	for (i = 0; i < T; i++) {
		scanf("%s", str);
		len = strlen(str);
		printf("%c%c\n", str[0], str[len-1]);
	}
}