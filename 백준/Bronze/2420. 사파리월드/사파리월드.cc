#include <stdio.h>
int main()
{
	int n, m;
	unsigned int res;
	scanf("%d %d", &n, &m);
	if (n > m)res = n - m;
	else res = m - n;
	printf("%u", res);
}