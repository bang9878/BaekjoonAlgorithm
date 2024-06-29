#include <iostream>
using namespace std;
int main()
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int a, b, big, small;
	int mok, nmg, gcm, lcm;
	int T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> a >> b;
		big = (a >= b) ? a : b;
		small = (a < b) ? a : b;
		while (1) {
			mok = big / small;
			nmg = big % small;
			if (nmg == 0) {
				gcm = small;
				lcm = a * b / gcm;
				cout << lcm << '\n';
				break;
			}
			big = small;
			small = nmg;
		}
	}
}