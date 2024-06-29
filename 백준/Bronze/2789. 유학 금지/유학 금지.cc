#include <stdio.h>
int main()
{
	int i;
	char arr[101]="";
	scanf("%[^\n]", arr);
	for (i = 0; arr[i] != '\0'; i++) {
		if (arr[i] == 'C' || arr[i] == 'A' || arr[i] == 'M' || arr[i] == 'B' || arr[i] == 'R' || arr[i] == 'I' || arr[i] == 'D' || arr[i] == 'G' || arr[i] == 'E') {
			arr[i] = '@';
		}
	}
	for (i = 0; arr[i] != '\0'; i++) {
		if (arr[i] != '@')printf("%c", arr[i]);
	}
}