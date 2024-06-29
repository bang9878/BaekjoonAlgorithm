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
		for (int k = 0; k < 2 * i - 1; k++)cout << "*";
		cout << '\n';
	}
	
	for (int i = num - 1; i >= 0; i--) {
		for (int j = 0; j < tmp; j++)
		{
			cout << " ";
		}
		for (int k = 0; k < 2*i-1; k++)
		{
			cout << "*";
		}
		if (tmp <= num)tmp++;
		cout << '\n';
	}
}