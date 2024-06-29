#include <iostream>
using namespace std;
int main()
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int num;
	cin >> num;
	for (int i = 1; i <= num; i++)
	{
		for (int k = i; k < num; k++)cout << " ";
		for (int j = 1; j <= 2 * i - 1; j++)cout << "*";
		cout << '\n';
	}
}