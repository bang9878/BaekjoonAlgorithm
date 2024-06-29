#include <stdio.h>
int main()
{
	int h, m, s;
	int time, h1, m1, s1;
	scanf("%d %d %d", &h, &m, &s);
	scanf("%d", &time);
	h1 = time / 3600;
	m1 = (time % 3600) / 60;
	s1 = (time % 3600) % 60;
	h += h1;
	m += m1;
	s += s1;

	if (s > 59) {
		s -= 60;
		m += 1;
	}
	if (m > 59) {
		m -= 60;
		h += 1;
	}
	while (h > 23) {
		h -= 24;
	}
	printf("%d %d %d", h, m, s);
}