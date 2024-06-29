#include <iostream>
using namespace std;
int main()
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int num;
	cin >> num;
	for (int i = 1; i <= 9; i++)
	{
		cout << num << " " << "*" << " " << i << " " << "=" << " " << num * i;
		cout << '\n';
	}
}