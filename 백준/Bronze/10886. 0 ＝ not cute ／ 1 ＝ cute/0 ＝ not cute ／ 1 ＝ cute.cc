#include <stdio.h>
int main()
{
	int n, test, cute=0, n_cute=0;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &test);
		if (test == 1)cute++;
		else n_cute++;
	}
	if (cute > n_cute)printf("Junhee is cute!");
	else printf("Junhee is not cute!");
}