#include <stdio.h>
#include <string.h>
int main()
{
	int T;
	double num;
	char arr[100];
	scanf("%d", &T);
	for (int i = 0; i < T; i++) {
		scanf("%lf", &num);
		scanf("%[^\n]", arr);
		for (int j = 0; arr[j] != '\0'; j++) {
			if (arr[j] == '@')num *= 3;
			if (arr[j] == '%')num += 5;
			if (arr[j] == '#')num -= 7;
		}
		printf("%.2f\n", num);
		num = 0;
	}
}