#include <iostream>
using namespace std;
int main()
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int num, i;
	int sum = 1;
	int cnt = 0;
	cin >> num;
	for (i = 1; sum < num; i++)
	{
		sum = sum + i * 6;
		cnt++;
	}
	cout << cnt+1;
}