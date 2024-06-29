#include <iostream>
using namespace std;
int main()
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int num;
	int tmp=1;
	cin >> num;
	for (int i = 1; i <= num; i++)
	{
		for (int j = i; j < num; j++)cout << " ";
		for (int k = 1; k <= 2 * i - 1; k++)
		{
			if (k % 2 == 0)cout << " ";
			else cout << "*";
		}
		cout << '\n';
	}
}