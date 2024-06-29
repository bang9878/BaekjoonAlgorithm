#include <stdio.h>
int main()
{
	int number[5];
	int i, sum = 0, temp;
	int mid, avg;
	for (i = 0; i < 5; i++) {
		scanf("%d", &number[i]);
		sum += number[i];
	}
	avg = sum / 5;
	for (i = 0; i < 5; i++) {
		for (int j = 0; j < 5 - i - 1; j++) {
			if (number[j] > number[j + 1]) {
				temp = number[j];
				number[j] = number[j + 1];
				number[j + 1] = temp;
			}
		}
	}
	mid = number[2];
	printf("%d %d", avg, mid);
}